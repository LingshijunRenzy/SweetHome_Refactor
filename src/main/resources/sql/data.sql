-- 注入示例用户数据
INSERT INTO user (username, password, email, phone, avatar,
                  signature, article_count, comment_count, liked_count, follow_count, fans_count, is_admin, status)
VALUES
('零食', '123123', '114514@qq.com', '13105516874', 'avatar1.jpg', '被爱是种神迹', 1, 2, 3, 4, 5, 1, 1),
('鲁迅', '123456', '123@456.com', '18988112345', 'avatar2.jpg', '两颗枣树', 1, 2, 3, 4, 5, 0, 1),
('李白', '123456', '111@datang.com', '', 'avatar3.jpg', '与尔同销万古愁', 1, 2, 3, 4, 5, 0, 1),
('田所浩二', '123456', '114514@1919810.com', '1145141919810', 'avatar4.jpg', '逸一时，误一世', 1, 2, 3, 4, 5, 0, 1);

-- 注入示例文章数据
INSERT INTO article (title, content, user_id, view_count, like_count, comment_count, status)
VALUES
('将进酒',
 '君不见黄河之水天上来，奔流到海不复回。
君不见高堂明镜悲白发，朝如青丝暮成雪。
人生得意须尽欢，莫使金樽空对月。
天生我材必有用，千金散尽还复来。
烹羊宰牛且为乐，会须一饮三百杯。
岑夫子，丹丘生，将进酒，杯莫停。
与君歌一曲，请君为我倾耳听。
钟鼓馔玉不足贵，但愿长醉不复醒。
古来圣贤皆寂寞，惟有饮者留其名。
陈王昔时宴平乐，斗酒十千恣欢谑。
主人何为言少钱，径须沽取对君酌。
五花马、千金裘，呼儿将出换美酒，与尔同销万古愁',
 3, 100, 50, 20, 1),

('百草园与三味书屋',
 '百草园与三味书屋，皆在市东南隅。
百草园中草木深，三味书屋名声故。
百草园中每日有，三味书屋不时无。
百草园中鸟自啼，三味书屋人自愉。',
 2, 50, 30, 10, 1);

INSERT INTO comments (content, user_id,article_id, like_count, status)
VALUES
('这是一条评论', 123,123, 0,1);