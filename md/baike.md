# jdk1.7
# servlet3.0 tomcat7 

�����������
removeRemoteLemma
removeLocalLemma

��̨����ϵͳ��http://admin.baike.soso.com/bkadmin/app

ǰ̨��http://baike.soso.com/Admin.htm

lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);

lemmaManager.getNewestLemma(60600895);


// ���һ�������汾
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
		newLemma.setLastEditorReason("ɾ��amazon");
		newLemma.setContentId(lemmaSubmitMgr.idAlloc.getNextId());

		newLemma.setStructInfo(null);
		
		this.lemmaManager.editLemma(newLemma, "Beni", "60");

// �û��ȼ�
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

// ������Ʒ
������Ʒ��

lemmaId=111080;
lemmaGridManager.getStarGridDirectly(lemmaId).getMovies()
lemmaGridManager.getStarGrid(lemmaId).getMovies()
//lemmaGridManager.cache.remove("STAR_GRID_"+lemmaId)
lemmaManager.removeLocalLemma(lemmaId)
lemmaManager.removeRemoteLemma(lemmaId)


sql:
delete or update 
gridData where lemmaId=111080 and directory in ('movie','tvplay','topMusic');

// ״̬Ϊ2�Ĵ���
lemmaManager.removeLocalLemma(85772258);
lemmaManager.removeRemoteLemma(85772258)
lemmaManager.getNewestLemma(85772258).isAuditLogical()
//lemmaManager.lemmaEngine.lemmaRpcDao.updateState(85772258,6,true)


// �õ�����id
new File("/tmp/lemma_category0716_result_1.txt").withWriter { w ->
   new File("/tmp/lemma_category0716.txt").eachLine {
     lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     def result = lemmaManager.getLemmaByTitle(it.split("\t")[0]);
     w.println "${result}\t${it}"
   }
}

// �õ�����id
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

// �õ�����title
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


// �õ�����ժҪ������
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

// ���Ǵ���pv
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


// ���� analyse/category/{lemmaFile}
/allsub/{category}
http://10.104.19.160:9011/services/category/allsub/����/
// �����ļ��ķ���
http://category.baike.soso.com/services/category/analyse/category/1224.txt
http://10.204.19.153:9011/services/category/analyse/category/kate0708.txt

// �õ������µ����д���
http://category.baike.soso.com/services/category/alllemma/��Ϸ

//����
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

// ���»�
{\"greatEvent\":[{\"time\":\"1981��\",\"title\":\"��������Ȧ\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1981.jpg\",\"description\":\"1981�����»�������10�����ߵ�����Աѵ���࣬ͬ��ͬѧ������������һԡ������䡢������ȣ��Լ׼�����ɼ���ҵ�������ߵ���̨��Ա����\u201c��۵�̨���Ӳ�\u201d�������ӵ�Ԫ�硶�����ۡ����������ټ������״��ݳ������ǲ����������ӽڵ��Ӿ��ر𽱡�\"},{\"time\":\"1982��\",\"title\":\"תս����Ļ\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1982.jpg\",\"description\":\"���»���1982�꿪ʼ���ݵ�Ӱ���ײ���Ʒ��С��ִ���ġ�������������һ��������Ҫ��ɫ�ĵ�Ӱ��Ʒ����1982������ִ���ġ�Ͷ��ŭ���������»��Դ�Ƭ��õڶ�����۵�Ӱ�����������Ա������\"},{\"time\":\"1983��\",\"title\":\"\u201c�����廢��\u201d�ߺ�\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1983.jpg\",\"description\":\"1983������������������ջ�������ΰ������ΰ������ҵ���\u201c�����廢��\u201d���������ˡ�������¡�����¹���ǡ��ȶಿ���ܻ�ӭ�����߾缯�����С�������¡������»���Ϊ��Ҫ�ĵ��Ӿ��������\"},{\"time\":\"1985��\",\"title\":\"������̳\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1985.jpg\",\"description\":\"1985�����»�������̳����һ��ר����ֻ֪���˿̰��㡷δ��úܴ���졣��һ�׳ɹ����еĸ����Ǻ��еġ���еĽ������е�ͬ������衣��ż���ȳ��£����»�����ѧ�ѡ������������Ǳ���ý��Ϊ\u201c�Ĵ�����\u201d���������������»�����ʱ����\"},{\"time\":\"2000��\",\"title\":\"�׻�������������\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2000.jpg\",\"description\":\"2000�꿪ʼ�����»���Ӱ���ĵ��۷�ʱ�ڣ�����ս���������й�Ů����������������������Ů������Ʊ���Ϳڱ���Ӯ�üѼ���������2000��ƾ�衶��ս�����ߵ�19����۵�Ӱ������������ǡ�\"},{\"time\":\"2007��\",\"title\":\"���\u201c�����ͺ���\u201d\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2007.jpg\",\"description\":\"�����ͺ��У���ֻСţ��ż�����������»�������\u201c����\u201d�����������»��ڲ߻�ר����һ��ţ���������硷ʱ��������У��������Ӱ������ж�ס�ʱ��һ�����ʱ��\u201c��\u201d�����ģ����Ϊ���ð������µ��������ٴ�\u201c��\u201d���˺��С���󰲶��ͺ���ȫ���������Ȧ����Ϊ����ż��\"}],\"starVideo\":[{\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://vpic.video.qq.com/49078056/6DMzSNPFnHz_160_90_3.jpg\",\"videoId\":\"6DMzSNPFnHz\",\"name\":\"�����ְ��ԡ����»�����������Ǹ ����������к���\"},{\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://vpic.video.qq.com/485633/7LYZI87WVT2_160_90_3.jpg\",\"videoId\":\"7LYZI87WVT2\",\"name\":\"�����ֱ��ϡ����»�����30������ؼ� ���������˱���\"},{\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://vpic.video.qq.com/3230317/m0012ln5ti1_160_90_3.jpg\",\"videoId\":\"m0012ln5ti1\",\"name\":\"�����㻨����δ������ ����֮���»�ƪ\"},{\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://vpic.video.qq.com/76140721/7T3BEjVdP0H_160_90_3.jpg\",\"videoId\":\"7T3BEjVdP0H\",\"name\":\"����˿���������»���������\"}]}

// ����lemma��module
import com.soso.baike.domain.Lemma;
 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(4962641L);
     result.setModule("{\"greatEvent\":{\"content\":[{\"time\":\"1981��\",\"title\":\"��������Ȧ\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1981.jpg\",\"description\":\"1981�����»�������10�����ߵ�����Աѵ���࣬ͬ��ͬѧ������������һԡ������䡢������ȣ��Լ׼�����ɼ���ҵ�������ߵ���̨��Ա����\u201c��۵�̨���Ӳ�\u201d�������ӵ�Ԫ�硶�����ۡ����������ټ������״��ݳ������ǲ����������ӽڵ��Ӿ��ر𽱡�\"},{\"time\":\"1982��\",\"title\":\"תս����Ļ\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1982.jpg\",\"description\":\"���»���1982�꿪ʼ���ݵ�Ӱ���ײ���Ʒ��С��ִ���ġ�������������һ��������Ҫ��ɫ�ĵ�Ӱ��Ʒ����1982������ִ���ġ�Ͷ��ŭ���������»��Դ�Ƭ��õڶ�����۵�Ӱ�����������Ա������\"},{\"time\":\"1983��\",\"title\":\"\u201c�����廢��\u201d�ߺ�\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1983.jpg\",\"description\":\"1983������������������ջ�������ΰ������ΰ������ҵ���\u201c�����廢��\u201d���������ˡ�������¡�����¹���ǡ��ȶಿ���ܻ�ӭ�����߾缯�����С�������¡������»���Ϊ��Ҫ�ĵ��Ӿ��������\"},{\"time\":\"1985��\",\"title\":\"������̳\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua1985.jpg\",\"description\":\"1985�����»�������̳����һ��ר����ֻ֪���˿̰��㡷δ��úܴ���졣��һ�׳ɹ����еĸ����Ǻ��еġ���еĽ������е�ͬ������衣��ż���ȳ��£����»�����ѧ�ѡ������������Ǳ���ý��Ϊ\u201c�Ĵ�����\u201d���������������»�����ʱ����\"},{\"time\":\"2000��\",\"title\":\"�׻�������������\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2000.jpg\",\"description\":\"2000�꿪ʼ�����»���Ӱ���ĵ��۷�ʱ�ڣ�����ս���������й�Ů����������������������Ů������Ʊ���Ϳڱ���Ӯ�üѼ���������2000��ƾ�衶��ս�����ߵ�19����۵�Ӱ������������ǡ�\"},{\"time\":\"2007��\",\"title\":\"���\u201c�����ͺ���\u201d\",\"lemmaTitle\":\"���»�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/liudehua2007.jpg\",\"description\":\"�����ͺ��У���ֻСţ��ż�����������»�������\u201c����\u201d�����������»��ڲ߻�ר����һ��ţ���������硷ʱ��������У��������Ӱ������ж�ס�ʱ��һ�����ʱ��\u201c��\u201d�����ģ����Ϊ���ð������µ��������ٴ�\u201c��\u201d���˺��С���󰲶��ͺ���ȫ���������Ȧ����Ϊ����ż��\"}],\"title\":\"���¼�\"},\"starVideo\":{\"content\":[{\"starVideoCollections\":[{\"picUrl\":\"http://vpic.video.qq.com/49078056/6DMzSNPFnHz_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"�����ְ��ԡ����»�����������Ǹ ����������к���\",\"videoId\":\"6DMzSNPFnHz\"},{\"picUrl\":\"http://vpic.video.qq.com/485633/7LYZI87WVT2_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"�����ֱ��ϡ����»�����30������ؼ� ���������˱���\",\"videoId\":\"7LYZI87WVT2\"},{\"picUrl\":\"http://vpic.video.qq.com/3230317/m0012ln5ti1_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"�����㻨����δ������ ����֮���»�ƪ\",\"videoId\":\"m0012ln5ti1\"},{\"picUrl\":\"http://vpic.video.qq.com/76140721/7T3BEjVdP0H_160_90_3.jpg\",\"videoUrl\":\"\",\"name\":\"����˿���������»���������\",\"videoId\":\"7T3BEjVdP0H\"}],\"tag\":\"����\"}],\"title\":\"��Ƶ����\"}}");
	ctx.getBean("daoFactory").getFsDao().modify(result);

	// �������
	lemmaManager.removeLocalFs(result.getContentId());

	lemmaManager.removeRemoteFs(result.getContentId());


import com.soso.baike.domain.Lemma;
 lemmaManager=ctx.getBean(com.soso.baike.manager.LemmaManager.class);
     Lemma result = lemmaManager.getNewestLemma(69454L);
     result.setModule("{\"greatEvent\":[{\"time\":\"1998��\",\"title\":\"��һ���缴����������\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming1998.jpg\",\"description\":\"�������ӵ���������һ�����Ӿ�\u2014�����鲻����Ϸ�����������껪��ˮ���ƻ𡷣���������Ф׿һ�ǲ��۲��۵���һ�ţ��þ�������̨Ͷ�ʡ����������ȴ����ƽƽ��������ˣ��ⲿ�������ǻ������������ĵ�һ�����ˡ�\"},{\"time\":\"2001��\",\"title\":\"Ϊ���ڷ��׳������������ӡ�\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2001.jpg\",\"description\":\"��һ�꣬��������Ͷ�ʷ����У�����������ʷ�硶�����ӡ������������ǣ���Ҳ���������ĳɹ������˺����\u201c����\u201d��һ�����ⲿϷ������˵���ŷǱ�Ѱ�������壬����һ�����ٶ�����Ͳ������þ��̨��쵽�ڵأ�\u201c������\u201d�����ֱ�ý��㷺��ע��\"},{\"time\":\"2007��\",\"title\":\"�������Ÿ���ר������̳С������\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2007.jpg\",\"description\":\"���������������Ÿ���ר����It's Ming������̤���̳��ɨ�������ְ佱����\u201c�������\u201d\u201c���ܻ�ӭ����\u201d\u201cȫ������\u201d\u201c������\u201d�Ƚ�����С�ʲô�����ԡ��͡��������ȸ�����Ϊ��������Ϊ�ܶ���KTV�ص���Ŀ��\"},{\"time\":\"2009��\",\"title\":\"���ݡ������� ��𼦰ٻ��������������\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2009.jpg\",\"description\":\"���й��ײ���ս��Ƭ���������У���������ս���ɣ����ݵ��վ�������س�����õ�ҵ����ʿ�͹��ڵ��Ͽɡ���Ҳƾ���Ƭ��𼦽��������Ǽ��ٻ������������������\"},{\"time\":\"2010��\",\"title\":\"����\u201c������������\u201d ����Ӱ��Ͷ��\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2010.jpg\",\"description\":\"�뿪ǩԼ����Ļ����ֵܣ��뾭���˻Ʊ�ͬ����\u201c������������\u201d�������Ѳ���ಿӰ�Ӿ��Ͷ�ʣ����������γ�Ʒ�ˣ�ͬʱ�������ơ����ꡢ���������߶����򳡵ȶ������\"},{\"time\":\"2013��\",\"title\":\"��絣�������㵼ʦ\",\"picUrl\":\"http://cache.soso.com/baike/news_baike/star/huangxiaoming2013.jpg\",\"description\":\"�����������䡢���졢��ΰ��һ���ζ������Ӵ���ѡ���Ŀ���й���֮������ʦ�����ڽ�Ŀ�����Ա�\u201c����\u201d���뺫�켤�ǣ���������¸ҳ�����Ѭױ���ͣ�������࣬���ⲻ�ϣ���չ��������ҵ����һո������\"}],\"starPic\":[{\"tag\":\"����д��\",\"starPicCollections\":[{\"pageUrl\":\"http://p.qpic.cn/baikepic/16520/cov-20130815211030-573637153.jpg/0\",\"dataId\":1003,\"name\":\"��������Ƭ\",\"dataTotal\":8},{\"pageUrl\":\"http://p.qpic.cn/baikepic/16509/cov-20130816121225-1273272338.jpg/0\",\"dataId\":1005,\"name\":\"������������\",\"dataTotal\":3},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2982/cov-20130816121246-418139845.jpg/0\",\"dataId\":1006,\"name\":\"������ʱ��д��\",\"dataTotal\":10},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2981/cov-20130816121255-1435758282.jpg/0\",\"dataId\":1007,\"name\":\"������ͼƬ��\",\"dataTotal\":3},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2983/cov-20130815211719-1907413907.jpg/0\",\"dataId\":1008,\"name\":\"����������\",\"dataTotal\":5}]},{\"tag\":\"��Ű���\",\"starPicCollections\":[{\"pageUrl\":\"http://p.qpic.cn/baikepic/18256/cov-20130816121327-1198341193.jpg/0\",\"dataId\":1009,\"name\":\"������ͼƬ��\",\"dataTotal\":2},{\"pageUrl\":\"http://p.qpic.cn/baikepic/3887/cov-20130816121511-1564570336.jpg/0\",\"dataId\":1010,\"name\":\"������͵��ϵ��\",\"dataTotal\":4},{\"pageUrl\":\"http://p.qpic.cn/baikepic/2987/cov-20130816121517-470060014.jpg/0\",\"dataId\":1011,\"name\":\"������������ޱ\",\"dataTotal\":12},{\"pageUrl\":\"http://p.qpic.cn/baikepic/16485/cov-20130815212244-299894435.jpg/0\",\"dataId\":1012,\"name\":\"��������angelababy\",\"dataTotal\":5},{\"pageUrl\":\"http://p.qpic.cn/baikepic/18262/cov-20130816121553-699226371.jpg/0\",\"dataId\":1013,\"name\":\"�������Ը���\",\"dataTotal\":3}]}],\"starVideo\":[{\"picUrl\":\"http://vpic.video.qq.com/34663587/f0012s73u17_160_90_3.jpg\",\"name\":\"���й���֮������ʦ��������¼\",\"videoId\":\"f0012s73u17\"},{\"picUrl\":\"http://vpic.video.qq.com/57732478/l00129fwuac_160_90_3.jpg\",\"name\":\"�������Գ��Ը�ܲ��ʺϵ�����\",\"videoId\":\"l00129fwuac\"},{\"picUrl\":\"http://vpic.video.qq.com/68888410/d0012wfgslp_160_90_3.jpg\",\"name\":\"����������ޱ Ů�ѳԴ�\",\"videoId\":\"a00123ywi4f\"},{\"picUrl\":\"http://vpic.video.qq.com/63687826/i00112aom7a_160_90_3.jpg\",\"name\":\"��������Ҫ��Ů��\",\"videoId\":\"i00112aom7a\"}]}");
	ctx.getBean("daoFactory").getFsDao().modify(result);
// �������
	lemmaManager.removeLocalFs(result.getContentId());



// ɾ�������е�ͼ��
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

// �õ�lemma id
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


// �жϴ��Ƿ�Ϊ����
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

// �������Ƿ��б��
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

// �ṹ�����
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

// �����Ӱ��������
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

// ͬ���
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

// �鿴�Ƿ���starPic
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


// �ж��Ƿ���ͼƬ��ժҪ
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

// ͬ�������
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

// ȥ��������
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

// ������
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

// ΢����΢�ţ���ά��
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

// �ж��Ƿ���ͼƬ��������
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

// ͬ����ڰٿ��Ƿ����
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

// ��ӻ���
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





// �鿴�Ƿ����ñ�ǩ
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



// top��������
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
     // �Ƿ�Ϊ����
     if(rtn.getScore() >=4 || (rtn.getProperty() & LemmaRaw.ELITE)){
    	line+="����\t"; 
     }else{
    	line+="������\t"; 
     }
     
     // �Ƿ�����
     if(rtn.isLocked() || rtn.isAuthLocked()){
    	 line+="����\t";
     }else{
    	 line+="û����\t";
     }

     picAbs=rtn.getPic();
     if(picAbs==null || picAbs.isEmpty() ){
    	 line+="����ժҪͼƬ\t";
     }else{
    	 line+="��ժҪͼƬ\t"
     }
     abs=rtn.getAbstracts();
     if(abs==null || abs.isEmpty() ){
    	 line+="ժҪ��\t";
     }else{
    	 line+="ժҪ�ǿ�\t"
     }

     cardItems=lemmaManager.getAllCardItem(lemmaId);
 if(cardItems==null || cardItems.isEmpty() ){
line+="�޻�����Ϣ��\t";
}else{
line+="�л�����Ϣ��\t"
}
     paragraphSize=rtn.getParagraphs().size();
  line+=paragraphSize+"\t";
     
  // category
  List<String> categories=lemmaManager.getCategorys(lemmaId);
  if(categories==null || categories.isEmpty()){
  line+="�޷���\t";
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
  line+="��tag\t";
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
line+="������ͼƬ\t";
break;
}
}
  
w.println "$line"

}catch(Exception ex){
w.println "$it,ex"
}

}
}


// ���߱��
import com.soso.baike.util.*;
tableContent=lemmaManager.getNewestLemma(113393L).getParagraphs().get(2).getContent();
PortalStrUtil.toWapText(tableContent,true);


// �����汾ver0 ver1
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

// ������ֵõ��û�������
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





// ������������
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

// ��ɾ������
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

// ɾ������
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

// ɾ�������ָ�
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

// ���������ļ�
import com.soso.baike.manager.*;
import com.soso.baike.xmlbean.*;
lemmaXmlManager=ctx.getBean(LemmaXmlManager.class);
a=lemmaXmlManager.getLemmaInfoXmlBean(71700L,100);
a==null
a.toFile("/data/beni/aaa.xml",LemmaInfoXmlBean.class);

# ���Դ��������ļ�
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

// �������������
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

// ��̨���ͨ����ǰ̨����ʾ
EditLimitService.removeEditLimit,ע�⣬���洫����id,����title

// ��֤����
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

// �õ��û�����̬
import com.soso.baike.util.*;
new File("/data/beni/kateqqR.txt").withWriter { w ->
   new File("/data/beni/kateqq.txt").eachLine {
	uid=UidCrypt.encode(it)
	w.println "${it},http://baike.sogou.com/u_${uid}.htm"
}
}

// ���ݴ�������ȡ���࣬tag
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

// ����id��ȡ���࣬tag
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

// ��̨��������Ч���������ݿ⣬�Ȼ�����Ч
import com.soso.baike.lemma.*;
lemmaId=94806L;
lemmaManager.removeLocalLemma(lemmaId);
lemmaManager.removeRemoteLemma(lemmaId);
lemmaManager.removeLocalFs(lemmaId);
lemmaManager.removeRemoteFs(lemmaId);
lemmaManager.getNewestLemmaDirect(lemmaId).getContentId();
// lemmaManager.getNewestLemma(lemmaId).getContentId();
lemmaManager.lemmaEngine.lemmaRpcDao.getLemmaView(lemmaId).getLemma().getContentId();



// ɾ�������汾
import com.soso.baike.audit.lemma.*;
import com.soso.baike.domain.*;
LemmaOperation.deleteVersion(713211L, 81839950L, IdConvert.valueOf(408866256L));



http://baike.sogou.com/h713211.htm?sp=l81839950



// �鿴�����Ƿ���Ч
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

// �����������
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


// ��������ʾ���°汾
import com.soso.baike.audit.*;
import com.soso.baike.audit.db.*;
import com.soso.baike.audit.lemma.*;
import  com.soso.baike.audit.lemma.*;
lemmaWriteBackOp=ctx.getBean(LemmaWriteBackOp.class);
lemmaAuditDao=LemmaAuditDao.getInstance();
lemmaRecord=lemmaAuditDao.getLemmaRecordByContentId(85317510)
lemmaWriteBackOp.writeBack(lemmaRecord);


// ���뷨
import com.soso.baike.domain.*;

new File("/data/analyse/renwu111Rb8.txt").withWriter { w ->
   new File("/data/analyse/renwu111Rb.txt").eachLine {

try{
     lemma =  lemmaManager.getNewestLemma(Long.parseLong(it));
      if(lemma.isAmbiguous()){
		ambiguation=lemma.getAmbiguation();
		lemmaId=getMainAmbiLemmaId(ambiguation);
		if(lemmaId==it){
			w.println "${ambiguation}\t|\t�鿴�ٿ�\t|\thttp://baike.sogou.com/v${it}.htm?cid=bk.srf.lx"
		}
	}else{
			w.println "${lemma.getTitle()}\t|\t�鿴�ٿ�\t|\thttp://baike.sogou.com/v${it}.htm?cid=bk.srf.lx"
}

}catch(Exception ex) {
//	w.println ",$it"
}
	
}
}



// �����õ������
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



// �ʼ� 
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
										composeMail.setSubject("�ٿƻ����");
										composeMail.setTexttype("html");
										composeMail.setTo(String.valueOf(friendId));
										composeMail.setUin(uin);
										composeMail.setAppname("sstcjx");
										composeMail.setF("xml");
										composeMail.setClientip("172.27.24.11");
										SendMail.send(composeMail);


// ��Ϣ������
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

// ��Ϣ����������հ���Ϣ
import  com.soso.baike.usercenter.manager.*;
userCenterManager=ctx.getBean(UserCenterManager.class);
lemmaUser=userManager.getUser("519470139");
userCenterManager.getMessage(lemmaUser,0,0)
userCenterManager.messageBoxService.getMsg(519470139, 2)
msgTypeDatas=userCenterManager.messageBoxService.iface.msgbox_get_all_msg(519470139).getNo_read_msgs()
//userCenterManager.messageBoxService.messages(msgTypeDatas, false, 519470139);
//msgTypeDatas.get(0).getMsgs().get(0).getLemma_audit_not_pass_msg()


// ͼ�����
import com.soso.baike.manager.*;
import com.soso.baike.common.msg.impl.*;
qqClientShowManager=ctx.getBean(QQClientShowManager.class);
//qqClientShowManager.canFirstLightOn(408866256);
//qqClientShowManager.notifyNewQQClientShowOnCondition(408866256)

// ��ʼ������
 MsgCenterManager.instance().setQQClientShow("1653530377",false,UserClientShowMsg.SHOW_TYPE_INIT);
qqClientShowManager.getQQClientShow(1653530377)
//qqClientShowManager.daoFactory.getSendMsgDao().client1
//qqClientShowManager.daoFactory.getSendMsgDao().client

// Ϩ��
MsgCenterManager.instance().setQQClientShow(userId+"",false,UserClientShowMsg.SHOW_TYPE_FORCE);
qqClientShowManager.getQQClientShow(userId)

canFirstLightOn


// ɾ����������Ϊ���°汾
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
			if("�޸Ļ�����Ϣ".equals(reason)){
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



