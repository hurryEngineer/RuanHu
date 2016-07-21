package edu.nju.logic.impl;

import edu.nju.data.dao.VoteDAO;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.aspectj.weaver.ast.ITestVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class TransferImpl implements TransferService {

    @Autowired
    private TimeService timeService;

    @Autowired
    private VoteDAO voteDAO;

    @Autowired
    private Wiki_httpDAO wiki_httpDAO;

    @Override
    public QuestionVO transferQuestion(Question question, long userId) {
        QuestionVO questionVO = new QuestionVO(question);
        if (question.getCreatedAt()!=null)
            questionVO.setCreateAtForView(timeService.timeToString(question.getCreatedAt()));
        if (question.getLastUpdatedAt()!=null)
            questionVO.setUpdateAtForView(timeService.timeToString(question.getLastUpdatedAt()));
        questionVO.setVote(voteDAO.hasVoteQuestion(userId, question.getId()));

        String s = "{\"exist\":1,\"data\":{\"title\":\"唐诗宋词原理分享\",\"categories\":[\"他就是爱吃火锅\"],\"currVersionString\":\"0.1\",\"editor\":\"dzm14\",\"visits\":6,\"date\":\"2016-07-18 09:19:04\",\"tags\":[\"Andorra\"],\"content\":\"v2.0本意是进行数据上的优化。但是由于数据量很大，存储方式由原先的写在代码中，变为在文件中，因此不得不采用异步方式，这样原先的代码绝大部分都不能使用了。\\n\\n#原理分享\\n\\n主要进行了以下几个步骤的工作：\\n+ 从网络上抓取大量诗词数据\\n+ 按格式将诗词分类\\n+ 对诗词正文进行分词操作\\n+ 统计各词出现的频率\\n+ 统计五言、七言诗句的句型，并将高频句型作为模板保存。\\n+ 根据参数或者随机挑选模板，然后使用词库渲染之。\\n\\n##1、 抓取诗词\\n首先选定了 http://so.gushiwen.org/ 这个网站作为抓取的目标，这个网站上收录的诗词数量也很可观，词也基本都是主流诗人写的，是很好的数据源。总共抓取了71000首。\\n\\n观察发现，所有诗歌的正文都在形如http://so.gushiwen.org/view_XXX.aspx的网页上（XXX是数字），这大大简化了抓取操作。\\n\\n具体抓取和解析代码在「poem-spider.js」中。最后解析出来的结果被保存在「docs/poems.txt」中。\\n\\n##2、 分类\\n这一步采用了正则表达式匹配诗文，将五言、七言诗等分开保存。\\n具体代码在「poem-selector.js」中。目前解析了七言诗和五言诗，保存在「docs/QiYan.txt」和「docs/WuYan.txt」中\\n\\n##3、 分词\\n为了实现词语频率的统计，以及后续词性的分析，首先要进行的是分词操作。\\n找到了这样一个分词工具：http://thulac.thunlp.org/demo。\\n下载得到了两个部分的文件：\\n```\\nTHULAC_lite_java_run.jar\\nmodels/\\n```\\njar文件是进行分词的可执行文件，models文件夹包含一些官方提供的训练数据，用以执行分词操作。\\n针对唐诗，分词效果其实还有提升的空间，比如说下面这样的：\\n```\\n神皋福 地 三 秦邑 ， 玉台 金阙九仙家 。 寒光 犹恋 甘泉树 ， 淑景 偏 临建 始 花 。\\n```\\n其中金阙九仙家应该可以被分词为金阙/九仙/家。但是这些词对人来说已经比较难懂了，估计不容易通过训练得到改善。不过好在后面的统计操作，基本能够把这些无意义的分词筛掉。\\n\\n分词时的命令很简单：\\n```bash\\n$> java -jar thulac\\\\\\\\thulac.jar -seg_only -input data\\\\\\\\WuYan.txt -output data\\\\\\\\Separate_WuYan.txt\\n```\\n具体代码在「poem-separate.js」中。\\n##4、 统计词频\\n使用字典显然是统计词频的最好的选择。\\n每读取到一个词就在字典中创建这个条目，或者将这个词的计数增加1。\\n具体的代码在「high-freq-word.js」中，最后筛选出了所有出现大于1次的词语，结果保存在「docs/high-frequency-word.csv」中。\\n\\n光光统计高频词语是显然不够的，还需要保存词语相应的信息。\\n根据之前的思路，需要保存的信息包括：\\n+ 字数\\n+ 平仄\\n+ 词性\\n+ （韵脚）\\n\\n因此大体上将词以csv的格式保存在`A/[平仄]/[词性]/[字数]`(如果不需要押韵)或`B/[平仄]/[韵脚]/[词性]/[字数]`(如果需要押韵)的文件中。 。\\n韵脚和平仄怎么办？！求助万能的github，发现这样一个前辈写好的js库：https://github.com/hotoo/pinyin 。\\n##5、统计模板\\n继续求助上文的分词工具，生成形如`[词性][字数]([是否押韵])/...`这样的模板。\\n比如：\\n```\\n自从关路入秦川，争道何人不戏鞭。\\n```\\n将会被分词为：\\n```\\n 自从_p 关路_n 入_v 秦川_ns ，_w 争道_v 何人_r 不_d 戏鞭_v 。\\n```\\n进而，其句型信息为：\\n```\\n['p2/n2/n1/ns2/', 'v2/r2/d12/']\\n```\\n注：由于一些词性，例如`ns`、`ni`等，都属于同一范畴，可以将他们都合并到名词。因此在分词和保存模板的时候，将许多词性进行了合并。\\n当然了，除了句型信息，还要有平仄信息。由于平仄与句型并没有直接的关联（在绝句中），因此将句型和平仄分两部分保存。\\n查阅了一下绝句的平仄规律，以及拗句的情况等等。。最后讲平仄模板写在了代码中。预计有30+个不同的模板。\\n最后模板信息保存在「word/WuYan_templates.txt」和「word/QiYan_templates.txt」中。\\n\\n##6、渲染\\n渲染就是简单的用生日取当前模板或词库文件的模，得到序号。\\n大功告成。。。。。。。。。。。。。。。。。。。。。。。。。。\\n。\\n。\\n。\\ntoo naive.\\n实际渲染的时候，常常会出现死循环的情况。于是打印出了出现死循环情况的模板信息：发现一个共同点，模板信息中都会出现`id7/`、`id5/`等类型的单元，这种超长的词法单元是由于词法分析工具没有正确的分词造成的。因此，痛下杀手，将所有带有`id`以及包含字数大于3的词法单元的模板全部剔除。这一下不得了，剔除了大约60%的模板。可见，在诗词方面，thulac的分词工具还有很大的提升空间。\\n\\n好了，这下再也没有出现过死循环的情况。\\n\\n#7、优化\\n生成多首诗的时候，会出现每首词都需要可观的时间。分析后得出诊断，应该是读取文件的耗时。于是使用单例模式，在第一次访问某个文件时将这个文件的内容加载到一个字典中，下次直接从字典中读取。经过测试，后续的词生成速度很快。\\n\\n随便贴首词出来：\\n```\\n[ '争心酒欢无近信', '淮北山围摆震雷', '沦迹兰芽垒潏潏', '兼仆潏潏蹭白眉' ]\\n[ '吊影自蹉跎', '防知静近郭', '暨滴昏朔雾', '起望自蹉跎' ]\\n\\n```\\n咦！居然有重复的词！\\n原来，在挑选词的时候，简单的根据生日信息取模来取词，一旦遇到两个一样的词法单元，比如`n2/`，平仄信息都是`+-`，那么取出的词一定是一样的。于是乎，在遍历模板的时候，每次将生日增加10.大大减少了重复的概率。\\n\\n来首优化后的词吧，意境还是有的：\\n```\\n寒宵月生筹政事，\\n韶濩秦关百岸风。\\n哲匠公堂美利戒，\\n文学魏帝断弦声。\\n```\\n\\n#自我反省\\n##一、代码\\n先从最浅层的说起。这次采用了脚本语言nodejs。最明显的特点就是他的异步性，因此习惯了同步编程的我，常常不小心调入回调的坑，无法用异步的思想来思考问题。\\n\\n当我需要从文件中读取词汇，然后拼装成整句。我调用`fetch()`函数从词库中获取某行内容，在读取结束后，通过回调函数返回值。这导致了从比较大的词库中获取的词将最迟被返回，于是我很不美丽得设置了一个flag，用于标记总词法单元数，每返回一个词就检查是否所有模板中的词法单元都被渲染了，当所有词法单元都被渲染了，就调用回调函数返回结果。这导致这段代码十分难懂。现在觉得，可以调用`async`库，采用顺序执行的方式解决问题，代码一定简洁的多，也好读的多。\\n\\n另外就是代码复用性的问题，现在的渲染函数只能渲染每句长度相同的模板，对于词模板，还缺乏拼装的能力。这个功能，日后还需要加上。\\n\\n## 二、思路\\n上部分已经说明了，本次的唐诗宋词项目的基本思路是：\\n* 生成模板\\n* 取词\\n* 渲染\\n\\n这可以满足：押韵的要求、一定程度上的语义要求（仅限于词性搭配）、平仄的要求。\\n生成一首完美的诗词，这显然是不够的。至于更高的设想，在后面的部分会探讨一下。\\n\\n#横向比较\\n##一、神经网络\\n> http://www.chinacloud.cn/show.aspx?id=22916&cid=14\\n这是一个运用机器学习的方法生成唐诗的例子。本人因此稍微去补习了下神经网络的知识。\\n神经网络通过很多神经单元组成的中间层，一层一层将输入信息简化，直到最上面一层，将输入信息提取成一个向量或是矩阵。\\n在生成近体诗的运用中，我们可以把大量的唐诗宋词数据（得瑟一下：这篇文章作者说收集唐诗数据用了一周，而我———用了在图书馆的某个悠闲的下午的三个小时）输入到神经网络，让它学习到怎么样的文法才是近体诗。\\n在生成阶段：不断向诗词后随机拼接词语，然后选择语义和文法上得分最高的词。\\n显然，平仄、语义、押韵、句型，都是神经网络需要动用神经单元分析的内容。而这个作者显然没有考虑到平仄和押韵问题。神经网络对硬件，或者说对算法的优化要求很高。这个作者为了保证性能上的可行性，显然在算法和学习程度上做出了不少的让步。如果神经网络进行了足够多的学习，相信效果会非常好。\\n\\n##二、遗传算法\\n> http://wenku.baidu.com/link?url=huObOPinQbPxr5v525JdqkhWuP_HdCdN-GsvrM_e--txpIJ8TCr9Ky1D0BO9ji8a9VYVfg3WYMcPeWD0Q9aPR0S1_89G8sT_L5Mn49q7BWu\\n\\n（挖坑学习中）\\n\\n##三、和我一样的词库拼接型\\n基本都是那样啦。。。效果上，真的没觉得有好上天的。\\n\\n\\n#天马行空的设想\\n以上的所有算法，包括那个我一知半解的遗传算法，包括自己的算不上算法的「套路」，都是从诗词的表面上，通过分析现有诗词，逆向解决问题。\\n思考是否可以通过模拟作诗的步骤，正向解决问题。\\n\\n**前期工作：**\\n* 学习句型\\n* 组建关联词库，就是包含了「修饰」的关系的词语对，甚至是词群，表示这些词出现在一起更加有意义\\n* 平仄、押韵等等知识的储备\\n* 学习常见的诗词「主题」和这些主题对应的关键词。\\n\\n**生成：**\\n* 拟定诗词主题，再通过一定程度上的发散，确定若干个关键词\\n* 通过类似搜索引擎的工作，用关键词搜索出一些相关的主干词，组成主干词库。\\n* 根据现有的句型知识，尝试着填入一些词，然后搜索关联词库，填入更多有意义的词。\\n\"}}\n";
        WikiItem item = null;
        List<WikiItem> list = new ArrayList<>();
        try {
            item = wiki_httpDAO.getWikiByString(s);
            list.add(item);
            list.add(item);
            list.add(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
        questionVO.setWikiItems(list);
        return questionVO;
    }

    @Override
    public AnswerVO transferAnswer(Answer answer, long userId) {
        AnswerVO answerVO = new AnswerVO(answer);
        if (answer.getCreatedAt()!=null)
            answerVO.setCreateAtForView(timeService.timeToString(answer.getCreatedAt()));
        if (answer.getLastUpdatedAt()!=null)
            answerVO.setUpdateAtForView(timeService.timeToString(answer.getLastUpdatedAt()));
        answerVO.setIsVote(voteDAO.hasVoteAnswer(userId, answer.getId()));
        return answerVO;
    }
}
