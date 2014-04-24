# 每天定点执行
```
# web.xml
<listener>
		<listener-class>com.soso.baike.listener.TimeListener</listener-class>
	</listener>
# Listener
public class TimeListener implements ServletContextListener {

	private static Timer timer;

	private static RePushJob job = new RePushJob();

	public static final Logger logger = Logger.getLogger("repush");

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			timer = new Timer(true);
			GregorianCalendar now = new GregorianCalendar();
			// 每天3:00执行
			now.set(Calendar.HOUR_OF_DAY, 3);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			timer.schedule(job, now.getTime());

		} catch (Exception e) {
			logger.error("RePushListener contextInitialized ex", e);
		}
		logger.info("RePushListener contextInitialized end");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("RePushListener contextDestroyed start");
		if (timer != null) {
			timer.cancel();
		}
		logger.info("RePushListener contextInitialized end");
	}
}
# Job
public class RePushJob extends TimerTask {

	public static final Logger logger = Logger.getLogger("repush");

	private static String pushErrorPath = "";
	static {
		Properties properties = PropUtil.loadIPSpecProperties(SogouPush.class, "/%s/config.properties", "/config.properties");
		pushErrorPath = properties.getProperty("PUSH_ERROR_PATH");
		logger.info("pushErrorPath:"+pushErrorPath);
	}

	@Override
	public void run() {
		try {
			// 读取前一天的失败文件
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			
			SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy_MM_dd");
			String file = pushErrorPath + dataFormat.format(new Date(calendar.getTimeInMillis()));

			logger.info("start read file:" + file);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				try {
				} catch (Exception ex) {
					logger.error("ex:" + line, ex);
				}
			}

			bufferedReader.close();
		} catch (Exception ex) {
			logger.error("repushJob:", ex);
			ex.printStackTrace();
		}
	}

}


```
