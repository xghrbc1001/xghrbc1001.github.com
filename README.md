# How to read

* md   markdown files,access it will be ok
* html generate from source md  by pandoc

# pandoc
## 转html
```Bash
pandoc 01-chapter2.md -o chapter2.html -c Github.css
```
## 转word
```Bash
pandoc 01-chapter2.markdown -o chapter2.docx -c Github.css
```
# How to write code

```Java
public static void main(String [] args) {
	System.out.println("Hello world,I'm Beni!");
}
``` 


