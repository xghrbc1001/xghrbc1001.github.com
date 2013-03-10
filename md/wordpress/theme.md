## 主题制作常用函数

* <? php bloginfo('name'); ?> - 调用博客标题
* <? php bloginfo('stylesheet_url'); ?> - 调用style.css
* <? php bloginfo('url'); ?> - 博客链接
* <? php bloginfo('description'); ?> - 博客描述
* 循环文章
```php
  <?php if(have_posts()) : ?> - 查看博客是否有日志
  <a href="<?php the_permalink(); ?> <?php the_title(); ?></a> - 调用日志标题及超链接
  <?php while(have_posts()): the_post(); ?> - 调用具体日志显示
  <?php the_content(); ?> - 显示内容
  <?php endwhile; ?>
  <? php else : ?>
	<?php _e('not found'); ?>
  <? php endif; ?>
```

* <?php _e('Filed under:'); ?> - 输出Filed under:,可支持多语言
* <?php the_category(',') ?> - 调用日志所有类别
* <?php the_author(); ?> - 输出日志作者
* <?php comments_popup_link('No Comments?','1 Comment?','% Comments?'); ?> - ? 用来显示数字,? 显示为>>
* <?php edit_post_link('Edit','|',''); ?> - 显示编辑
* <?php the_ID(); ?> - 日志id
* <?php posts_nav_link(); ?> - 调用下一页和前一页的链接
* <?php wp_list_cats('sort_column=name&optioncount=1&hierarchical=0'); ?> - 调用分类链接列表
* <?php wp_list_pages(); ?> - 页面链接列表
* <?php wp_get_archives('type=monthly'); ?> - 存档列表
* <? php get_links_list(); ?> - 友情链接
