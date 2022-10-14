## 食物表

```
`CREATE TABLE `tb_food` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,`
    `name` varchar(50) DEFAULT NULL,
    `canteen` varchar(50) DEFAULT NULL,
    `floor` int DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```


## 用户表

```
CREATE TABLE `tb_user` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(50) DEFAULT NULL,
    `email` varchar(50) DEFAULT NULL,
    `password` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```


## 收藏表

~~~
CREATE TABLE `tb_favourite` (
    `food_id` int unsigned DEFAULT NULL,
    `user_id` int unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
~~~

