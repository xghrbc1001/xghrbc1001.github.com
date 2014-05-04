# document.html()´ø<html>±êÇ©
```
		Document doc=Jsoup.parse("<div><sup><a href='#para'>ksdjfk</a></sup></div>");
		doc.select("sup").remove();
		System.out.println(doc.text());
		System.out.println(doc.body().html());

```
