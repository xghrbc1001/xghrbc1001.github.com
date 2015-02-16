# jdk1.7
# servlet3.0 tomcat7 

清除词条缓存
removeRemoteLemma
removeLocalLemma

后台管理系统：http://admin.baike.soso.com/bkadmin/app

前台：http://baike.soso.com/Admin.htm

lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);

lemmaManager.getNewestLemma(60600895);


// 添加一个词条版本
import com.soso.baike.domain.*;
import java.util.Date;
lemmaId=46056;	
Lemma old = this.lemmaManager.getNewestLemmaDirect(lemmaId);
		
		Date currTime = new Date();
		String userId="408866256";
		Lemma newLemma=old;
		newLemma.setLastEditorId(userId);
		newLemma.setLastEditorName("Beni");
		newLemma.setLastEditTime(currTime);
		newLemma.setLastEditorReason("删除amazon");
		newLemma.setContentId(lemmaSubmitMgr.idAlloc.getNextId());

		newLemma.setStructInfo(null);
		
		this.lemmaManager.editLemma(newLemma, "Beni", "60");

// 用户等级
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
new File("/data/beni/userR.txt").withWriter { w ->
   new File("/data/beni/user.txt").eachLine {
userId=Long.parseLong(it);
userManager=ctx.getBean(UserManager.class);
level=userManager.getUser(userId).getLevelId();
w.println "${it}\t${level}"
}
}

// 代表作品
代表作品：

lemmaId=111080;
lemmaGridManager.getStarGridDirectly(lemmaId).getMovies()
lemmaGridManager.getStarGrid(lemmaId).getMovies()
//lemmaGridManager.cache.remove("STAR_GRID_"+lemmaId)
lemmaManager.removeLocalLemma(lemmaId)
lemmaManager.removeRemoteLemma(lemmaId)


sql:
delete or update 
gridData where lemmaId=111080 and directory in ('movie','tvplay','topMusic');

// 状态为2的词条
lemmaManager.removeLocalLemma(85772258);
lemmaManager.removeRemoteLemma(85772258)
lemmaManager.getNewestLemma(85772258).isAuditLogical()
//lemmaManager.lemmaEngine.lemmaRpcDao.updateState(85772258,6,true)


// 得到词条id
new File("/tmp/lemma_category0716_result_1.txt").withWriter { w ->
   new File("/tmp/lemma_category0716.txt").eachLine {
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     def result = lemmaManager.getLemmaByTitle(it.split("\t")[0]);
     w.println "${result}\t${it}"
   }
}

// 得到词条id
import com.soso.baike.util.*;
new File("/data/beni/all_merit_nameR6").withWriter { w ->
   new File("/data/beni/all_merit_name").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     lemma= LemmaSearchUtil.getByWord(it);
     if(lemma==null) {
           w.println "0\t${it}"
      } else {
     def result =lemma.getLemmaId();
     w.println "${result}\t${it}"
    }
}catch(Exception ex){
 w.println "0\t${it}"
}
   }
}

// 得到词条title
import com.soso.baike.domain.Lemma;
new File("/tmp/starsResult").withWriter { w ->
   new File("/tmp/stars").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(Long.parseLong(it));
     w.println "${it}\t${result.getTitle()}"
}catch(Exception ex) {
     w.println "${it}}"
}
   }
}


// 得到词条摘要，正文
import com.soso.baike.domain.Lemma.Paragraph;
import com.soso.baike.domain.Lemma;
import org.jsoup.Jsoup;
new File("/tmp/top25W_jason_result_2.txt").withWriter { w ->
   new File("/tmp/top25W_jason.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(lemmaManager.getLemmaByTitle(it));
	String content=result.getAbstracts()+"@@@";
	List<Paragraph> paragraphs=result.getParagraphs();
	for(Paragraph paragraph : paragraphs ) {
		content+=paragraph.getContent();
	}
	content=Jsoup.parse(content.replaceAll("\r\n"," ").replaceAll("\n"," ")).text();
     w.println "${it}@@@${content}"
   
}catch(Exception ex) {
     w.println "${it}"
}
}
}

// 明星词条pv
import com.soso.baike.pv.export.PvInfo;
import com.soso.baike.manager.*;
new File("/tmp/lemmastar0806Result.txt").withWriter { w ->
   new File("/tmp/lemmastar0806.txt").eachLine {
try{
    PvInfo info = LemmaPvManager.getInstance().getLemmaPv(Long.parseLong(it.split("\t")[0]));
    if(info==null ) {
     w.println "info null ============================="
    }else{
	long pv=info.getPv();
     w.println "${it}\t${pv}"
}
   
}catch(Exception ex) {
     w.println "${it} ${ex}"
}
}
}


// 分类 analyse/category/{lemmaFile}
/allsub/{category}
http://10.104.19.160:9011/services/category/allsub/人物/
// 分析文件的分类
http://category.baike.soso.com/services/category/analyse/category/1224.txt
http://10.204.19.153:9011/services/category/analyse/category/kate0708.txt

// 得到分类下的所有词条
http://category.baike.soso.com/services/category/alllemma/游戏

//字数
import com.soso.baike.domain.Lemma;
new File("/tmp/20131023Result.txt").withWriter { w ->
   new File("/tmp/20131023.txt").eachLine { title ->

	try{
 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
def lemmaId=lemmaManager.getLemmaByTitle(title);
def paragraphs = lemmaManager.getNewestLemma(lemmaId).getParagraphs();
w.print "${title}\t${lemmaId}\t"
String content="";
paragraphs.each { paragraph ->
	try {
     def out=paragraph.content.replaceAll("\r\n","").replaceAll("\n","");
     content+=out;
} catch(ex){
}
}
     w.println "${content.length()}"
}catch(e){
     w.println "${title}\t"
}
   }
}

// 刘德华
{\"greatEvent\":[{\"time\":\"1981年\",\"title\":\"初入演艺圈\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1981.jpg\",\"description\":\"1981年刘德华考进第10期无线电视艺员训练班，同期同学有吴家丽、梁家辉、戚美珍、徐锦江等，以甲级优异成绩毕业后任无线电视台演员。在\u201c香港电台电视部\u201d制作电视单元剧《香港香港》、《江湖再见》里首次演出任主角并获美国电视节电视剧特别奖。\"},{\"time\":\"1982年\",\"title\":\"转战大银幕\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1982.jpg\",\"description\":\"刘德华于1982年开始参演电影，首部作品吴小云执导的《彩云曲》，第一部担演重要角色的电影作品则是1982年许鞍华执导的《投奔怒海》，刘德华以此片获得第二届香港电影金像奖最佳新演员提名。\"},{\"time\":\"1983年\",\"title\":\"\u201c无线五虎将\u201d走红\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1983.jpg\",\"description\":\"1983年受无线力捧，与黄日华，梁朝伟，苗侨伟，汤镇业组成\u201c无线五虎将\u201d，并出演了《神雕侠侣》、《鹿鼎记》等多部很受欢迎的无线剧集，其中《神雕侠侣》是刘德华最为重要的电视剧代表作。\"},{\"time\":\"1985年\",\"title\":\"进军歌坛\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1985.jpg\",\"description\":\"1985年刘德华进军乐坛，第一张专辑《只知道此刻爱你》未获得很大回响。第一首成功流行的歌曲是后发行的《情感的禁区》中的同名主打歌。在偶像热潮下，刘德华与张学友、黎明、郭富城被传媒封为\u201c四大天王\u201d，开启了属于刘德华娱乐时代。\"},{\"time\":\"2000年\",\"title\":\"首获金像奖最佳男主角\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2000.jpg\",\"description\":\"2000年开始是刘德华电影生涯的巅峰时期，《暗战》、《孤男寡女》、《阿虎》、《瘦身男女》等在票房和口碑上赢得佳绩，并且在2000年凭借《暗战》荣膺第19届香港电影金像奖最佳男主角。\"},{\"time\":\"2007年\",\"title\":\"设计\u201c安逗和黑仔\u201d\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2007.jpg\",\"description\":\"安逗和黑仔，两只小牛玩偶，是天王刘德华的两个\u201c儿子\u201d。安逗是刘德华在策划专辑《一个牛的异想世界》时产生的灵感，在拍摄电影《见龙卸甲》时花一整天的时间\u201c生\u201d出来的，其后，为了让安逗不孤单，所以再次\u201c生\u201d下了黑仔。随后安逗和黑仔全面进入娱乐圈，成为虚拟偶像。\"}],\"starVideo\":[{\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://vpic.video.qq.com/49078056/6DMzSNPFnHz_160_90_3.jpg\",\"videoId\":\"6DMzSNPFnHz\",\"name\":\"【娱乐八卦】刘德华含泪三度致歉 坚决否认已有孩子\"},{\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://vpic.video.qq.com/485633/7LYZI87WVT2_160_90_3.jpg\",\"videoId\":\"7LYZI87WVT2\",\"name\":\"【娱乐爆料】刘德华出道30年电视特辑 音乐制作人爆料\"},{\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://vpic.video.qq.com/3230317/m0012ln5ti1_160_90_3.jpg\",\"videoId\":\"m0012ln5ti1\",\"name\":\"【拍摄花絮】未来警察 花絮之刘德华篇\"},{\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://vpic.video.qq.com/76140721/7T3BEjVdP0H_160_90_3.jpg\",\"videoId\":\"7T3BEjVdP0H\",\"name\":\"【粉丝剪辑】刘德华歌曲串烧\"}]}

// 更新lemma的module
import com.soso.baike.domain.Lemma;
 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(4962641L);
     result.setModule("{\"greatEvent\":{\"content\":[{\"time\":\"1981年\",\"title\":\"初入演艺圈\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1981.jpg\",\"description\":\"1981年刘德华考进第10期无线电视艺员训练班，同期同学有吴家丽、梁家辉、戚美珍、徐锦江等，以甲级优异成绩毕业后任无线电视台演员。在\u201c香港电台电视部\u201d制作电视单元剧《香港香港》、《江湖再见》里首次演出任主角并获美国电视节电视剧特别奖。\"},{\"time\":\"1982年\",\"title\":\"转战大银幕\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1982.jpg\",\"description\":\"刘德华于1982年开始参演电影，首部作品吴小云执导的《彩云曲》，第一部担演重要角色的电影作品则是1982年许鞍华执导的《投奔怒海》，刘德华以此片获得第二届香港电影金像奖最佳新演员提名。\"},{\"time\":\"1983年\",\"title\":\"\u201c无线五虎将\u201d走红\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1983.jpg\",\"description\":\"1983年受无线力捧，与黄日华，梁朝伟，苗侨伟，汤镇业组成\u201c无线五虎将\u201d，并出演了《神雕侠侣》、《鹿鼎记》等多部很受欢迎的无线剧集，其中《神雕侠侣》是刘德华最为重要的电视剧代表作。\"},{\"time\":\"1985年\",\"title\":\"进军歌坛\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1985.jpg\",\"description\":\"1985年刘德华进军乐坛，第一张专辑《只知道此刻爱你》未获得很大回响。第一首成功流行的歌曲是后发行的《情感的禁区》中的同名主打歌。在偶像热潮下，刘德华与张学友、黎明、郭富城被传媒封为\u201c四大天王\u201d，开启了属于刘德华娱乐时代。\"},{\"time\":\"2000年\",\"title\":\"首获金像奖最佳男主角\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2000.jpg\",\"description\":\"2000年开始是刘德华电影生涯的巅峰时期，《暗战》、《孤男寡女》、《阿虎》、《瘦身男女》等在票房和口碑上赢得佳绩，并且在2000年凭借《暗战》荣膺第19届香港电影金像奖最佳男主角。\"},{\"time\":\"2007年\",\"title\":\"设计\u201c安逗和黑仔\u201d\",\"lemmaTitle\":\"刘德华\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2007.jpg\",\"description\":\"安逗和黑仔，两只小牛玩偶，是天王刘德华的两个\u201c儿子\u201d。安逗是刘德华在策划专辑《一个牛的异想世界》时产生的灵感，在拍摄电影《见龙卸甲》时花一整天的时间\u201c生\u201d出来的，其后，为了让安逗不孤单，所以再次\u201c生\u201d下了黑仔。随后安逗和黑仔全面进入娱乐圈，成为虚拟偶像。\"}],\"title\":\"大事记\"},\"starVideo\":{\"content\":[{\"starVideoCollections\":[{\"picUrl\":\"http://vpic.video.qq.com/49078056/6DMzSNPFnHz_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"【娱乐八卦】刘德华含泪三度致歉 坚决否认已有孩子\",\"videoId\":\"6DMzSNPFnHz\"},{\"picUrl\":\"http://vpic.video.qq.com/485633/7LYZI87WVT2_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"【娱乐爆料】刘德华出道30年电视特辑 音乐制作人爆料\",\"videoId\":\"7LYZI87WVT2\"},{\"picUrl\":\"http://vpic.video.qq.com/3230317/m0012ln5ti1_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"【拍摄花絮】未来警察 花絮之刘德华篇\",\"videoId\":\"m0012ln5ti1\"},{\"picUrl\":\"http://vpic.video.qq.com/76140721/7T3BEjVdP0H_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"【粉丝剪辑】刘德华歌曲串烧\",\"videoId\":\"7T3BEjVdP0H\"}],\"tag\":\"集锦\"}],\"title\":\"视频集锦\"}}");
	ctx.getBean("daoFactory").getFsDao().modify(result);

	// 清除缓存
	lemmaManager.removeLocalFs(result.getContentId());

	lemmaManager.removeRemoteFs(result.getContentId());


import com.soso.baike.domain.Lemma;
 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(69454L);
     result.setModule("{\"greatEvent\":[{\"time\":\"1998年\",\"title\":\"第一部剧即担纲男主角\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming1998.jpg\",\"description\":\"黄晓明接到了人生第一部电视剧\u2014《爱情不是游戏》（又名《年华似水情似火》），他扮演肖卓一是不折不扣的男一号，该剧由中央台投资、播出，结果却反响平平，尽管如此，这部剧无疑是黄晓明演艺生涯的一个开端。\"},{\"time\":\"2001年\",\"title\":\"为观众奉献成名作《大汉天子》\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2001.jpg\",\"description\":\"这一年，黄晓明被投资方看中，担当大型历史剧《大汉天子》三部曲男主角，他也不负重望的成功演绎了汉武帝\u201c刘彻\u201d的一生。这部戏对他来说有着非比寻常的意义，两年一部的速度拍摄和播出，该剧从台湾红到内地，\u201c黄晓明\u201d的名字被媒体广泛关注。\"},{\"time\":\"2007年\",\"title\":\"发行首张个人专辑，歌坛小试身手\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2007.jpg\",\"description\":\"黄晓明发行了首张个人专辑《It's Ming》。刚踏入歌坛横扫各大音乐颁奖典礼\u201c最佳新人\u201d\u201c最受欢迎新人\u201d\u201c全能艺人\u201d\u201c跨界歌手\u201d等奖项，其中《什么都可以》和《暗恋》等歌曲广为流唱，成为很多人KTV必点曲目。\"},{\"time\":\"2009年\",\"title\":\"参演《风声》 获金鸡百花最佳男主角提名\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2009.jpg\",\"description\":\"在中国首部谍战大片《风声》中，黄晓明挑战大反派，扮演的日军特务机关长武田得到业内人士和观众的认可。他也凭借此片获金鸡奖最佳男配角及百花奖最佳男主角提名。\"},{\"time\":\"2010年\",\"title\":\"成立\u201c黄晓明工作室\u201d 参与影视投资\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2010.jpg\",\"description\":\"离开签约三年的华谊兄弟，与经纪人黄斌共同成立\u201c黄晓明工作室\u201d。至今，已参与多部影视剧的投资，黄晓明担任出品人，同时还涉足红酒、饭店、互联网、高尔夫球场等多个领域。\"},{\"time\":\"2013年\",\"title\":\"跨界担任真人秀导师\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2013.jpg\",\"description\":\"黄晓明和李玟、韩红、王伟忠一起担任东方卫视大型选秀节目《中国梦之声》导师，他在节目中曾自爆\u201c想结婚\u201d，与韩红激吻，配合主题勇敢尝试烟熏妆造型，抢镜多多，话题不断，拓展了演艺事业的又一崭新领域。\"}],\"starPic\":[{\"tag\":\"封面写真\",\"starPicCollections\":[{\"pageUrl\":\"http://p.qpic.cn/baikepic/16520/cov-20130815211030-573637153.jpg/0\",\"dataId\":1003,\"name\":\"黄晓明大片\",\"dataTotal\":8},{\"pageUrl\":\"http://p.qpic.cn/baikepic/16509/cov-20130816121225-1273272338.jpg/0\",\"dataId\":1005,\"name\":\"黄晓明封面照\",\"dataTotal\":3},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2982/cov-20130816121246-418139845.jpg/0\",\"dataId\":1006,\"name\":\"黄晓明时尚写真\",\"dataTotal\":10},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2981/cov-20130816121255-1435758282.jpg/0\",\"dataId\":1007,\"name\":\"黄晓明图片集\",\"dataTotal\":3},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2983/cov-20130815211719-1907413907.jpg/0\",\"dataId\":1008,\"name\":\"黄晓明美照\",\"dataTotal\":5}]},{\"tag\":\"绯闻八卦\",\"starPicCollections\":[{\"pageUrl\":\"http://p.qpic.cn/baikepic/18256/cov-20130816121327-1198341193.jpg/0\",\"dataId\":1009,\"name\":\"黄晓明图片集\",\"dataTotal\":2},{\"pageUrl\":\"http://p.qpic.cn/baikepic/3887/cov-20130816121511-1564570336.jpg/0\",\"dataId\":1010,\"name\":\"黄晓明偷拍系列\",\"dataTotal\":4},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2987/cov-20130816121517-470060014.jpg/0\",\"dataId\":1011,\"name\":\"黄晓明暗恋赵薇\",\"dataTotal\":12},{\"pageUrl\":\"http://p.qpic.cn/baikepic/16485/cov-20130815212244-299894435.jpg/0\",\"dataId\":1012,\"name\":\"黄晓明与angelababy\",\"dataTotal\":5},{\"pageUrl\":\"http://p.qpic.cn/baikepic/18262/cov-20130816121553-699226371.jpg/0\",\"dataId\":1013,\"name\":\"黄晓明性感照\",\"dataTotal\":3}]}],\"starVideo\":[{\"picUrl\":\"http://vpic.video.qq.com/34663587/f0012s73u17_160_90_3.jpg\",\"name\":\"《中国梦之声》导师黄晓明语录\",\"videoId\":\"f0012s73u17\"},{\"picUrl\":\"http://vpic.video.qq.com/57732478/l00129fwuac_160_90_3.jpg\",\"name\":\"黄晓明自称性格很不适合当艺人\",\"videoId\":\"l00129fwuac\"},{\"picUrl\":\"http://vpic.video.qq.com/68888410/d0012wfgslp_160_90_3.jpg\",\"name\":\"黄晓明抱赵薇 女友吃醋\",\"videoId\":\"a00123ywi4f\"},{\"picUrl\":\"http://vpic.video.qq.com/63687826/i00112aom7a_160_90_3.jpg\",\"name\":\"黄晓明想要的女孩\",\"videoId\":\"i00112aom7a\"}]}");
	ctx.getBean("daoFactory").getFsDao().modify(result);
// 清除缓存
	lemmaManager.removeLocalFs(result.getContentId());



// 删除词条中的图册
import com.soso.baike.domain.*;

new File("/data/beni/target").withWriter { w ->
   new File("/data/beni/source").eachLine {

 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(Long.parseLong(it));
	List<Paragraph> paragraphs=result.getParagraphs();
	if(paragraphs!=null ){
		for(Paragraph paragraph : paragraphs) {
			     w.println "${paragraph}\r\n"
		}
	}
}
}

// 得到lemma id
import com.soso.baike.domain.*;

new File("/data/beni/kate0828R.txt").withWriter { w ->
   new File("/data/beni/kate0828.txt").eachLine {

 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
try{
     result =  lemmaManager.getLemmaByTitle(it);
     category=lemmaManager.getCategorys(result);
	w.println "http://baike.sogou.com/v${result}.htm,$it,category"
}catch(Exception ex) {
	w.println ",$it"
}
	
}
}


// 判断词是否为义项
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
new File("/tmp/amb1216-R-3.txt").withWriter { w ->
   new File("/tmp/amb1216.txt").eachLine {
lemmaSubmitMgr=ctx.getBean(LemmaManager.class);
id=lemmaManager.getLemmaByTitle(it)
     Lemma rtn= lemmaManager.getNewestLemma(id);
isAmb=rtn.isAmbiguous();
	w.println "${isAmb},$it,${id}"

}
}

// 检查词条是否有表格
import com.soso.baike.domain.Paragraph;
import com.soso.baike.domain.Lemma;

new File("/tmp/allLemmaIdTable.txt").withWriter { w ->
   new File("/tmp/allLemmaId.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(Long.parseLong(it));

	boolean hasTable=false;
	List<Paragraph> paragraphs=result.getParagraphs();
	for(Paragraph paragraph : paragraphs ) {
		if(paragraph.getContent()==null ) {
			continue;
		}
		if(paragraph.getContent().indexOf("<table")!=-1){
			hasTable=true;
			break;	
		}
	}

     w.println "${it},${hasTable}"
   
}catch(Exception ex) {
     w.println "${it},ex"
}
}
}

// 结构化表格
import com.soso.baike.domain.Paragraph;
import com.soso.baike.domain.Lemma;
import org.json.JSONObject;

new File("/tmp/s5R.txt").withWriter { w ->
   new File("/tmp/s5.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(Long.parseLong(it));

	boolean hasTable=false;
	if(result.getModule()!=null) {
	JSONObject jsonObject = new JSONObject(result.getModule());
	if(jsonObject.has("movie") || jsonObject.has("tv")||jsonObject.has("concert")||jsonObject.has("music")||jsonObject.has("adv")||jsonObject.has("honor")||jsonObject.has("resume")) {
		hasTable=true;
	}
}

     w.println "${it},${hasTable}"
   
}catch(Exception ex) {
     w.println "${it},ex"
}
}
}

// 规则电影，连续剧
import com.soso.baike.domain.Paragraph;
import com.soso.baike.domain.Lemma;

new File("/tmp/top5WIDR8.txt").withWriter { w ->
   new File("/tmp/top5WID.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(Long.parseLong(it));
     title=result.getTitle();

	boolean hasTable=false;
	List<Paragraph> paragraphs=result.getParagraphs();
	StringBuilder sb=new StringBuilder("");
	for(Paragraph paragraph : paragraphs ) {
		if(paragraph.getContent()==null ) {
			continue;
		}
		sb.append(paragraph.getContent().replaceAll(" ","").replaceAll("\n","").replaceAll("&nbsp;",""));
	}

     w.println "${it},${title},${sb.toString()}"
   
}catch(Exception ex) {
     w.println "${it},${title},ex"
}
}
}

// 同义词
import com.soso.baike.manager.*;
new File("/tmp/syn0109R.txt").withWriter { w ->
   new File("/tmp/syn0109.txt").eachLine {
try{
	LemmaTitleManager lemmaTitleManager=ctx.getBean(LemmaTitleManager.class);
        LemmaManager lemmaManager=ctx.getBean(LemmaManager.class);
lemmaId=lemmaManager.getLemmaByTitle(it);
	result=lemmaTitleManager.getMainSynonym(it);
   
     w.println "${it}\t${lemmaId}\t${result}"
}catch(Exception ex) {
     w.println "${it}}"
}
   }
}

// 查看是否有starPic
import com.soso.baike.domain.Lemma;
import org.json.JSONObject;

String BLANK_CONTENT="\"content\":[]";
JSONObject jsonObject;
new File("/tmp/top5WID0127.txt").withWriter { w ->
   new File("/tmp/top5WID.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma lemma = lemmaManager.getNewestLemma(Long.parseLong(it));

	if (lemma.getModule() == null || lemma.getModule().isEmpty()) {
w.println "${it}\tno"
			} else {
				jsonObject = new JSONObject(lemma.getModule());
if(jsonObject.has("greatEvent") && !jsonObject.get("greatEvent").toString().contains(BLANK_CONTENT)){
w.println "${it}\tyes"
}else{
w.println "${it}\tno"
}
			}

}catch(Exception ex){
w.println "${it}\tex"
}
   }
}


// 判断是否有图片和摘要
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
new File("/tmp/top3wIdR4.txt").withWriter { w ->
   new File("/tmp/top3wId.txt").eachLine {
lemmaSubmitMgr=ctx.getBean(LemmaManager.class);
try{
     Lemma rtn= lemmaManager.getNewestLemma(Long.parseLong(it));
     pic=rtn.getPic();
     abs=rtn.getAbstracts();
     title=rtn.getTitle();
     if(pic!=null && abs!=null) {
	w.println "$it,$title,yes"
      }else{
w.println "$it,$title,no"
}
}catch(Exception ex){
w.println "$it,,ex"
}

}
}

// 同义词义项
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
import com.soso.baike.storage.export.Synonym;
import java.util.List;
new File("/tmp/0220-R5.txt").withWriter { w ->
   new File("/tmp/0220.txt").eachLine {
	lemmaSubmitMgr=ctx.getBean(LemmaManager.class);
try{
     Lemma rtn= lemmaManager.getNewestLemma(Long.parseLong(it));
// Lemma rtn= lemmaManager.getNewestLemma(lemmaManager.getLemmaByTitle(it));
title=rtn.getTitle();
	mainTitle=lemmaTitleManager.getMainSynonym(title);
   vices="";
List<Synonym> synonyms;
if(mainTitle==null){
synonyms=lemmaTitleManager.getViceSynonym(title);
}else{
synonyms=lemmaTitleManager.getViceSynonym(mainTitle.getTitle());

}

if(synonyms==null){
  vices="null";
}else{
   for(Synonym synonym: synonyms){
vices+=","+synonym.getLemmaTitle();
}
}
    isAmb=rtn.isAmbiguous();
     w.println "${it}###${title}###${isAmb}###${mainTitle}###${vices}"
}catch(Exception e){
    w.println "${it}###ex";
}

}
}

// 去除非主词
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
import com.soso.baike.storage.export.Synonym;
import java.util.List;
new File("/tmp/molly0328R.txt").withWriter { w ->
   new File("/tmp/molly0328.txt").eachLine {
try{
  Lemma rtn= lemmaManager.getNewestLemma(lemmaManager.getLemmaByTitle(it));
  title=rtn.getTitle();
  lemmaId=rtn.getLemmaId();
  mainTitle=lemmaTitleManager.getMainSynonym(title);
  if(mainTitle==null){
	w.println "${it}\thttp://baike.soso.com/v${lemmaId}.htm"
  }else{
w.println "${it}\thttp://baike.soso.com/v${lemmaId}.htm\t${mainTitle.getTitle()}\thttp://baike.soso.com/v${mainTitle.getId()}.htm"
	}
}catch(Exception ex){
	w.println "${it}\tex"
}

}
}

// 主副词
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
import com.soso.baike.storage.export.Synonym;
import java.util.List;
new File("/tmp/0310-R.txt").withWriter { w ->
   new File("/tmp/0310.txt").eachLine {
try{

  mainTitle=lemmaTitleManager.getMainSynonym(it);
  if(mainTitle==null){
	w.println "${it}\t${it}\tyes"
  }else{
w.println "${it}\t${mainTitle.getTitle()}\tno"
}
}catch(Exception ex){
	w.println "ex"
}

}
}

// 微博，微信，二维码
import com.soso.baike.service.easyconf.*;
starSocietyInfo=ctx.getBean(StarSocietyInfo.class);
HashMap<String,String> hm=new HashMap<String,String>();
//hm.put("wb","abc6");
//hm.put("wx","abc6");
hm.put("2dc","2dc1");
hm.put("name","abc2");
//starSocietyInfo.addStarSocietyInfo(hm, "benitest");
starSocietyInfo.reload();
starSocietyInfo.get2DC("2dc");

// 判断是否有图片及段落数
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
new File("/tmp/top3wIdR4.txt").withWriter { w ->
   new File("/tmp/top3wId.txt").eachLine {
lemmaSubmitMgr=ctx.getBean(LemmaManager.class);
try{
     Lemma rtn= lemmaManager.getNewestLemma(lemmaManager.getLemmaByTitle(it));
     pic=rtn.getPic();
     abs=rtn.getAbstracts();
     title=rtn.getTitle();
     paragraphSize=rtn.getParagraphs().size();
     if(pic!=null && abs!=null) {
	w.println "$it,$title,yes,$paragraphSize"
      }else{
w.println "$it,$title,no,$paragraphSize"
}
}catch(Exception ex){
w.println "$it,,ex"
}

}
}

// 同义词在百科是否存在
import com.soso.baike.domain.Lemma;
new File("/tmp/x1R.txt").withWriter { w ->
   new File("/tmp/x1.txt").eachLine {
try{
	String [] strs=it.split("\t");
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
    lemmaId= lemmaManager.searchLemmaByTitle(strs[1]);
if(lemmaId==0L){
     w.println "${it}\tnot"
}else{
     w.println "${it}\tyes"

}
}catch(Exception ex) {
     w.println "${it}}"
}
   }
}

// 添加积分
import com.soso.baike.manager.*;
scoreInfoManager=ctx.getBean(ScoreInfoManager.class);
scoreInfoManager.changeScore2("408866256",123456L,6,6,6,"HOTWORD_TASK");
userManager.clearLocalUser

import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
scoreInfoManager=ctx.getBean(ScoreInfoManager.class);
userManager=ctx.getBean(UserManager.class);
scoreInfoManager.changeScore2("795019752",123456L,6,600,600,"HOTWORD_TASK");
userManager.clearLocalUser(new IdConvert(795019752));
userManager.getUser(795019752).getLevelId();





// 查看是否设置标签
import com.soso.baike.domain.IdConvert;
userManager.getUser(new IdConvert(408866256L)).favourTagsSet();

// lemma lock
import com.soso.baike.service.easyconf.*;
List<LemmaLock> lemmaLocks=new ArrayList<LemmaLock>();
LemmaLock lemmaLock=new LemmaLock();
lemmaLock.setLemmaId(1L);
lemmaLock.setCode(1);
lemmaLock.setRemark("test");
lemmaLocks.add(lemmaLock);

lemmaManager.lemmaLockManager.createLemmaLock(lemmaLocks);



// top词条分析
import java.util.List;

import com.soso.baike.manager.*;
import com.soso.baike.util.LemmaSearchUtil;
import com.soso.baike.domain.*;
import com.soso.lemma.processor.domain.LemmaRaw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.soso.lemma.processor.domain.*;
new File("/data/analyse/allLemmaIdR.txt").withWriter { w ->
   new File("/data/analyse/allLemmaId.txt").eachLine {
lemmaSubmitMgr=ctx.getBean(LemmaManager.class);
try{
     String [] strs=it.split("\t");
     lemmaId=Long.parseLong(strs[0]);
     Lemma rtn=LemmaSearchUtil.getById(lemmaId);
     // Lemma rtn= lemmaManager.getNewestLemma(lemmaId);
     Lemma lemma=rtn;
     String line=   it+"\t"+  rtn.getTitle()+"\t";
     // 是否为优质
     if(rtn.getScore() >=4 || (rtn.getProperty() & LemmaRaw.ELITE)){
    	line+="优质\t"; 
     }else{
    	line+="非优质\t"; 
     }
     
     // 是否锁定
     if(rtn.isLocked() || rtn.isAuthLocked()){
    	 line+="锁定\t";
     }else{
    	 line+="没锁定\t";
     }

     picAbs=rtn.getPic();
     if(picAbs==null || picAbs.isEmpty() ){
    	 line+="不含摘要图片\t";
     }else{
    	 line+="含摘要图片\t"
     }
     abs=rtn.getAbstracts();
     if(abs==null || abs.isEmpty() ){
    	 line+="摘要空\t";
     }else{
    	 line+="摘要非空\t"
     }

     cardItems=lemmaManager.getAllCardItem(lemmaId);
 if(cardItems==null || cardItems.isEmpty() ){
line+="无基本信息栏\t";
}else{
line+="有基本信息栏\t"
}
     paragraphSize=rtn.getParagraphs().size();
  line+=paragraphSize+"\t";
     
  // category
  List<String> categories=lemmaManager.getCategorys(lemmaId);
  if(categories==null || categories.isEmpty()){
  line+="无分类\t";
  }else{
	  
	  String strCategory="|";
	  for(String str: categories){
		 strCategory+=str+"|"; 
	  }
	  line+=strCategory+"\t";
  }
  
  // tags
  List<String> tags=lemma.getLemmaTags();
  if(tags==null || tags.isEmpty()){
  line+="无tag\t";
  }else{
	  
	  String strTag="|";
	  for(String str: tags){
		 strTag+=str+"|"; 
	  }
	  line+=strTag+"\t";
  }

for(Paragraph paragraph: rtn.getParagraphs()){
if(paragraph.getContent()==null || paragraph.getContent().isEmpty()){
continue;
}
Document doc = Jsoup.parse(paragraph.getContent());
Elements imgs=doc.getElementsByTag("img");
if(imgs!=null&&!imgs.isEmpty()){
line+="正文有图片\t";
break;
}
}
  
w.println "$line"

}catch(Exception ex){
w.println "$it,ex"
}

}
}


// 无线表格
import com.soso.baike.util.*;
tableContent=lemmaManager.getNewestLemma(113393L).getParagraphs().get(2).getContent();
PortalStrUtil.toWapText(tableContent,true);


// 词条版本ver0 ver1
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
new File("/tmp/top3wIdR4.txt").withWriter { w ->
   new File("/tmp/top3wId.txt").eachLine {
lemmaSubmitMgr=ctx.getBean(LemmaManager.class);
try{
     Lemma rtn= lemmaManager.getNewestLemma(Long.parseLong(it));
    ver=rtn.getStructVersion();
    title=rtn.getTitle();
	w.println "$it###$title###$ver"

}catch(Exception ex){
w.println "$it###ex"
}

}
}

// 任务积分得到用户，词条
new File("/data/beni/task/score20140901-20141001R.txt").withWriter { w ->
   new File("/data/beni/task/score20140901-20141001.txt").eachLine {
try{
	String [] line=it.split("\t");
	Long userId=Long.parseLong(line[0]);
	Long contentId=Long.parseLong(line[1]);
	title=lemmaManager.getLemmaFromFs(contentId).getTitle();
	name=userManager.getUser(userId).getName();
	w.println "$it\t$title\t$name";
}catch(Exception){
w.println "$it\t";
}
}
}





// 导入主义项名
import com.soso.baike.manager.*;
import com.soso.baike.domain.*;
import com.soso.baike.storage.export.Synonym;
import java.util.List;
import com.soso.wenwen.util.structure.*;
new File("/tmp/c10R.txt").withWriter { w ->
   new File("/tmp/c10.txt").eachLine {
try{
		String title=it.split(" ")[0];
		String ambi=it.split(" ")[1];
		long lemmaId=0;
		List<Pair<String, Long>>  pairs=lemmaManager.getAmbiguationPairs(title);
		if(pairs==null|| pairs.isEmpty()){
			w.println "${title},${ambi},no pairs";
		} else {
	
		for(Pair<String,Long> pair:pairs){
			if(ambi.equals(pair.getFirst())){
				lemmaId=pair.getSecond();
				break;
			}
		}
		
		if(lemmaId!=0L){
			titleIdMapMgr.addMap(4001, title, lemmaId, 408866256L);
		w.println "${title},${ambi},success";
		}else{

			w.println "${title},${ambi},not found pairs";
			
		}
}

}catch(Exception ex){
	w.println "ex,${it}"
}

}
}

// 己删除数据
new File("/tmp/deletedLemmaR.txt").withWriter { w ->
   new File("/tmp/deletedLemma.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     lemma=lemmaManager.getNewestLemma(Long.parseLong(it));
     w.println "${it}\t${lemma.isDeleted()}\t${lemma.isDeleted()}\t${lemma.isAmbiguous()}\t${lemma.getTitle()}"
}catch(Exception ex){
w.println "${it}\tex"
}
   }
}

// 删除词条
import com.soso.baike.audit.lemma.*;
import com.soso.baike.domain.*;
new File("/tmp/lj2R.txt").withWriter { w ->
   new File("/tmp/lj2.txt").eachLine {
try{
	 rtn =LemmaOperation.deleteLemma(Long.parseLong(it), IdConvert.valueOf(408866256L));
    	 w.println "${it}\t${rtn}"
}catch(Exception ex){
	w.println "${it}\tex"
}
   }
}

// 删除词条恢复
import com.soso.baike.audit.lemma.*;
new File("/tmp/dnuR.txt").withWriter { w ->
   new File("/tmp/dnu.txt").eachLine {
try{
   
     rtn = LemmaOperation.undeleteLemma(Long.parseLong(it), 408866256L);
     w.println "${it}\t${rtn}"
}catch(Exception ex){
	w.println "${it}\tex"
}
   }
}

long lemmaId=36777L
daoFactory.getLemmaRpcDao().updateState(lemmaId,0x1000000,false);
lemmaManager.getNewestLemmaDirect(lemmaId).isDeleted();
lemmaManager.removeLocalLemma(lemmaId);
lemmaManager.removeRemoteLemma(lemmaId);
lemmaManager.getNewestLemmaDirect(lemmaId).isDeleted();

// 词条生成文件
import com.soso.baike.manager.*;
import com.soso.baike.xmlbean.*;
lemmaXmlManager=ctx.getBean(LemmaXmlManager.class);
a=lemmaXmlManager.getLemmaInfoXmlBean(71700L,100);
a==null
a.toFile("/data/beni/aaa.xml",LemmaInfoXmlBean.class);

# 测试词条生成文件
import com.soso.baike.manager.*;
import com.soso.baike.xmlbean.*;
lemmaXmlManager=ctx.getBean(LemmaXmlManager.class);
a=lemmaXmlManager.getLemmaInfoXmlBean(56289L,100);
a.toFile("/tmp/56289.xml",LemmaInfoXmlBean.class);

lemmaXmlManager=ctx.getBean(LemmaXmlManager.class);
a=lemmaXmlManager.getLemmaInfoXmlBean(6124L,100);
a.toFile("/tmp/6124.xml",LemmaInfoXmlBean.class);

lemmaXmlManager=ctx.getBean(LemmaXmlManager.class);
a=lemmaXmlManager.getLemmaInfoXmlBean(4962641L,100);
a.toFile("/tmp/4962641.xml",LemmaInfoXmlBean.class);

import com.soso.baike.manager.*;
lemmaXmlManager=ctx.getBean(LemmaXmlManager.class);
lemmaXmlManager.exportAllXml("/data/allLemma/input/xaa","/data/allLemma/outputa",1);

// 分析主义项词条
import com.soso.baike.domain.Lemma;
new File("/tmp/ambiguationR.txt").withWriter { w ->
   new File("/tmp/ambiguation.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     mainId = lemmaManager.getMainAmbiLemmaId(it.split("\t")[2]);
     w.println "${it}\t${mainId}"
}catch(Exception ex) {
     w.println "${it}}"
}
   }
}

// 后台审核通过，前台不显示
EditLimitService.removeEditLimit,注意，里面传的是id,不是title

// 认证锁定
import com.soso.baike.service.organization.*;
import com.soso.baike.service.organization.*;
import com.soso.baike.domain.IdConvert;
import com.soso.baike.service.organization.*;
// OrganizationService.getInstance().doService(packet);
// organizationService=new OrganizationService();

 packet = new GetLemmaListByOrgQQPacket(0, 100, IdConvert.valueOf(0));
OrganizationService.getInstance().doService(packet);
LemmaList lemmaList = (LemmaList)packet.getResult();
lemmaList.lemmaList .size();

// 得到用户客人态
import com.soso.baike.util.*;
new File("/data/beni/kateqqR.txt").withWriter { w ->
   new File("/data/beni/kateqq.txt").eachLine {
	uid=UidCrypt.encode(it)
	w.println "${it},http://baike.sogou.com/u_${uid}.htm"
}
}

// 根据词条名获取分类，tag
new File("/data/analyse/top10wR.txt").withWriter { w ->
   new File("/data/analyse/top10w.txt").eachLine {
try {
 lemmaId=lemmaManager.getLemmaByTitle(it);
 lemma=lemmaManager.getNewestLemma(lemmaId);
 tags=lemma.getTags();
 category=lemmaManager.getCategorys(lemmaId);
 w.println "${lemmaId}\t###\t${it}\t###\t${tags}\t###\t${category}";
}catch(Exception ex){
 w.println "${it}";
}

}
}

// 根据id获取分类，tag
new File("/data/beni/kate0903R.txt").withWriter { w ->
   new File("/data/beni/kate0903.txt").eachLine {
try {
 lemmaId=Long.parseLong(it);
 lemma=lemmaManager.getNewestLemma(lemmaId);
 tags=lemma.getTags();
 title=lemma.getTitle();
 category=lemmaManager.getCategorys(lemmaId);
 w.println "${lemmaId}\t###\t${title}\t###\t${it}\t###\t${tags}\t###\t${category}";
}catch(Exception ex){
}

}
}

// 后台词条不生效，更新数据库，等缓存生效
import com.soso.baike.lemma.*;
lemmaId=94806L;
lemmaManager.removeLocalLemma(lemmaId);
lemmaManager.removeRemoteLemma(lemmaId);
lemmaManager.removeLocalFs(lemmaId);
lemmaManager.removeRemoteFs(lemmaId);
lemmaManager.getNewestLemmaDirect(lemmaId).getContentId();
// lemmaManager.getNewestLemma(lemmaId).getContentId();
lemmaManager.lemmaEngine.lemmaRpcDao.getLemmaView(lemmaId).getLemma().getContentId();



// 删除词条版本
import com.soso.baike.audit.lemma.*;
import com.soso.baike.domain.*;
LemmaOperation.deleteVersion(713211L, 81839950L, IdConvert.valueOf(408866256L));



http://baike.sogou.com/h713211.htm?sp=l81839950



// 查看词条是否有效
import com.soso.baike.domain.Lemma;
new File("/data/beni/sogou.baike.url.okR.txt").withWriter { w ->
   new File("/data/beni/sogou.baike.url.ok.txt").eachLine {
try{
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma lemma= lemmaManager.getNewestLemma(Long.parseLong(it));
     if(lemma==null|| lemma.isDeleted()|| !lemma.isAuditLogical()|| lemma.isDirtyReportConfirming()){
  	 w.println "${it}\tnotok"
     }else{
     	 w.println "${it}\tok"
     }
}catch(Exception ex) {
     w.println "${it}"
}
   }
}

// 清除词条缓存
import com.soso.baike.lemma.LemmaFormKind;
import com.soso.baike.cache.builder.CacheFactory;
import com.soso.baike.lemma.LemmaEngine;
import com.soso.lemma.processor.domain.LemmaRaw;
lemmaId=127629;
cacheFactory=ctx.getBean(CacheFactory.class);
lemmaEngine=ctx.getBean(LemmaEngine.class);
LemmaRaw raw=lemmaEngine.getLemmaRaw(lemmaId, true);
String key = lemmaEngine.getCacheKey(raw.getContentId(), LemmaFormKind.DIRECT);
cacheFactory.getCache("fsCache").remove(key);
lemmaManager.removeLocalLemma(lemmaId);


// 词条不显示最新版本
import com.soso.baike.audit.*;
import com.soso.baike.audit.db.*;
import com.soso.baike.audit.lemma.*;
import  com.soso.baike.audit.lemma.*;
lemmaWriteBackOp=ctx.getBean(LemmaWriteBackOp.class);
lemmaAuditDao=LemmaAuditDao.getInstance();
lemmaRecord=lemmaAuditDao.getLemmaRecordByContentId(85317510)
lemmaWriteBackOp.writeBack(lemmaRecord);


// 输入法
import com.soso.baike.domain.*;

new File("/data/analyse/renwu111Rb8.txt").withWriter { w ->
   new File("/data/analyse/renwu111Rb.txt").eachLine {

try{
     lemma =  lemmaManager.getNewestLemma(Long.parseLong(it));
      if(lemma.isAmbiguous()){
		ambiguation=lemma.getAmbiguation();
		lemmaId=getMainAmbiLemmaId(ambiguation);
		if(lemmaId==it){
			w.println "${ambiguation}\t|\t查看百科\t|\thttp://baike.sogou.com/v${it}.htm?cid=bk.srf.lx"
		}
	}else{
			w.println "${lemma.getTitle()}\t|\t查看百科\t|\thttp://baike.sogou.com/v${it}.htm?cid=bk.srf.lx"
}

}catch(Exception ex) {
//	w.println ",$it"
}
	
}
}



// 义项缓存得到与清除
new File("/data/beni/ambiguationR.txt").withWriter { w ->
   new File("/data/beni/ambiguation.txt").eachLine {
try{
    ambiItems=lemmaManager.getAmbiguationItems(it);
    ambiItemDaos=lemmaManager.lemmaDao.getAmbiguationItems(it);
    if(ambiItems==null){
	w.println "${it}\tnull";
	}
     if(ambiItems.size() != ambiItemDaos.size()){
	w.println "${it}\tsize";
	}
}catch(Exception ex){
w.println "${it}\tex";
}
}
}



new File("/data/beni/ambiguationR2.txt").withWriter { w ->
   new File("/data/beni/ambiguationR1.txt").eachLine {
try{
  lemmaManager.removeAmbiCache(it);
w.println "${it}\tok";
}catch(Exception ex){
w.println "${it}\tex";
}
}
}



// 邮件 
import java.util.ArrayList;
import java.util.List;

import com.soso.baike.domain.ComposeMail;
import com.soso.baike.domain.LemmaUser;
import com.soso.baike.domain.QQUser;
import com.soso.baike.domain.activity.HotwordInviter;
import com.soso.baike.mail.SendMail;
import com.soso.baike.manager.HotLemmaActivityManager;
import com.soso.baike.manager.HotWordActivityManager;
import com.soso.baike.manager.UserManager;
import com.soso.baike.qqfriend.QQFriendHandler;
import com.soso.baike.service.CookieService;
import com.soso.baike.thrift.qqfriend.QQFriend;
import com.soso.baike.tips.QQTips;
import com.soso.baike.tool.UUIDGenerate;
import com.soso.baike.ui.ajax.BaseAjaxPage;
import org.apache.tapestry.RedirectException;
import com.soso.baike.ui.page.lemma.CreateV1;

import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.annotations.InjectObject;
import org.apache.tapestry.event.PageEvent;
import org.json.JSONObject;

uin=408866256L;
friendName="YiYi";	
friendId="1720120224";
userName="Beni";
inviteUUID="fasdf";
skey="cJB*zxwpyLH-*T6hfZdw3VJDy*b02J*w6bsv4CHK928_";
ComposeMail composeMail=new ComposeMail();
										composeMail.setBcc("");
										composeMail.setCc("");
										composeMail.setContent(String.format(SendMail.hotwordActivityMailContent,friendName,userName,"http://baike.soso.com/ajax/InviteQQFriend.htm?redirect=true&uin="+inviteUUID,"http://baike.soso.com/activity/HotLemmaActivity.htm"));
										composeMail.setFrom(String.valueOf(uid));
										composeMail.setSendmethod(0);
										composeMail.setSkey(skey);
										composeMail.setSubject("百科活动邀请");
										composeMail.setTexttype("html");
										composeMail.setTo(String.valueOf(friendId));
										composeMail.setUin(uin);
										composeMail.setAppname("sstcjx");
										composeMail.setF("xml");
										composeMail.setClientip("172.27.24.11");
										SendMail.send(composeMail);


// 消息盒问题
import  com.soso.baike.usercenter.manager.*;
userCenterManager=ctx.getBean(UserCenterManager.class);
lemmaUser=userManager.getUser("767535112");
userCenterManager.getUnReadMessage();
userCenterManager.getMessage(lemmaUser,0,0)
userCenterManager.messageBoxService.getMsg(767535112,0);

import  com.soso.baike.usercenter.manager.*;
import com.soso.baike.msgbox.*;
import  com.soso.baike.ucache.export.*;
import  com.soso.baike.domain.*;
userCenterManager=ctx.getBean(UserCenterManager.class);
userId="2259276265";
//lemmaUser=userManager.getUser("2259276265");
 User user=new User(Long.parseLong(userId));
			
			 LemmaUser lemmaUser=new LemmaUser(user);
lemmaUser.getIntegerId()
String key=lemmaUser.getIntegerId()+"_"+MessageModel.NOT_READ;
//userCenterManager.unReadMessageCountCache.containsKey(key)
//userCenterManager.unReadMessageCountCache.get(key)
userCenterManager.getUnReadMessage(lemmaUser);
//userCenterManager.getMessage(lemmaUser,0,0)
//userCenterManager.messageBoxService.getMsg(2259276265,0);
userCenterManager.messageBoxService.getMsg(lemmaUser.getIntegerId(), MessageModel.NOT_READ).size();
messageModels=userCenterManager.messageBoxService.iface.msgbox_get_all_msg(2259276265).getNo_read_msgs();
//userCenterManager.messageBoxService.getMsg(2259276265,0).size()
// messageModels.size()
 userCenterManager.messageBoxService.messages(messageModels, false, 2259276265).size()
messageModels

// 消息盒问题二，空白消息
import  com.soso.baike.usercenter.manager.*;
userCenterManager=ctx.getBean(UserCenterManager.class);
lemmaUser=userManager.getUser("519470139");
userCenterManager.getMessage(lemmaUser,0,0)
userCenterManager.messageBoxService.getMsg(519470139, 2)
msgTypeDatas=userCenterManager.messageBoxService.iface.msgbox_get_all_msg(519470139).getNo_read_msgs()
//userCenterManager.messageBoxService.messages(msgTypeDatas, false, 519470139);
//msgTypeDatas.get(0).getMsgs().get(0).getLemma_audit_not_pass_msg()


// 图标点亮
import com.soso.baike.manager.*;
import com.soso.baike.common.msg.impl.*;
qqClientShowManager=ctx.getBean(QQClientShowManager.class);
//qqClientShowManager.canFirstLightOn(408866256);
//qqClientShowManager.notifyNewQQClientShowOnCondition(408866256)

// 初始化点亮
 MsgCenterManager.instance().setQQClientShow("1653530377",false,UserClientShowMsg.SHOW_TYPE_INIT);
qqClientShowManager.getQQClientShow(1653530377)
//qqClientShowManager.daoFactory.getSendMsgDao().client1
//qqClientShowManager.daoFactory.getSendMsgDao().client

// 熄灭
MsgCenterManager.instance().setQQClientShow(userId+"",false,UserClientShowMsg.SHOW_TYPE_FORCE);
qqClientShowManager.getQQClientShow(userId)

canFirstLightOn


// 删除词条，作为最新版本
import com.soso.baike.audit.lemma.*;
import com.soso.baike.domain.*;

new File("/data/beni/1225/needDeleted1R.txt").withWriter { w ->
   new File("/data/beni/1225/needDeleted1.txt").eachLine {
try{
	lemmaId=Long.parseLong(it.split("\t")[0].trim());
	contentId=Long.parseLong(it.split("\t")[1].trim());
     // LemmaOperation.deleteVersion(lemmaId, contentId, IdConvert.valueOf(408866256L));
	LemmaOperation.deleteNewerVersions(lemmaId, contentId, IdConvert.valueOf(408866256L));
     w.println "${it}\tsuccess}"
}catch(Exception ex) {
     w.println "${it},ex}"
}
   }
}



import com.soso.lemma.processor.*;
import com.soso.lemma.processor.domain.*;
import com.soso.baike.domain.*;
import org.apache.commons.lang.math.*;
long lemmaId=37217280;
str="";
	long contentId=0L;
	LemmaHistoryResponse historyRes = lemmaManager.getLemmaHistoriesByPage(lemmaId,0,50);
	List<LemmaHistory> historyList = historyRes.getHistories();
	for(LemmaHistory lemmaHistory: historyList){
		String reason=lemmaHistory.getEditReason();
		contentId=lemmaHistory.getContentId();
		editorId=Long.parseLong(lemmaHistory.getEditorId());
		if((editorId > 2850001000) && (editorId < 2850021000)  ){
			if("修改基本信息".equals(reason)){
str+="1";
				continue;
			}else{
				str="abc";
				break;
			}
			;
		}else{
str+="2"
			break;
		}
	}
str



