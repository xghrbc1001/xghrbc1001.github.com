
```
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.util.EntityUtils;

private static DefaultHttpClient httpclient = new DefaultHttpClient(new ThreadSafeClientConnManager());

HttpGet httpGet = new HttpGet(WAP_URL + pushDomain.getLemmaId() + "&ver=" + version);
			HttpResponse responseWap = httpclient.execute(httpGet);
			// 返回不为200,如504等
			if (responseWap.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {

}
HttpEntity entity = responseWap.getEntity();
			if (entity == null) {
				return null;
			}

			inputStream = entity.getContent();
			if (inputStream == null) {
				return null;
			}
			outputStream = new FileOutputStream(new File(filePath));
			IOUtils.copy(inputStream, outputStream);

			if (entity != null) {
				EntityUtils.consume(responseWap.getEntity());
				entity.consumeContent();
			}


```
