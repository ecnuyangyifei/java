## 特性
- 解释型
- 动态类型
- 内存型
- 列存储
- 时序数据库
## 数据类型
- 基本数据类型
  - char,symbol,二进制类型（boolean, byte, GUID）整型（short，int, long），浮点型（real, float）, 日期类型（date, time...）
- List
- Dictionary
- Table
- Function
## 条件/循环控制
- control words, control words 不是function, 返回Identity(::)
  - do
  - if
  - while
## Iterators(Adverbs)
- Maps
  - each / peach
  - each left / right, cross
- Accumulators
  - scan
  - over
## q-sql
- insert/upsert
- delete
- select/update/exec
- 排序 xasc/xdesc
- 列重命名/重排序，xcol/xcols
- where子句
- by/fby, by类比sql的group by, fby类比sql的over patition by
- Join
  - ij/lj 右表必须为keyed table，列名称、类型须一致，重复列采用upsert语义
  - ej 对应SQL中inner join，右表不必为keyed table
  - pj, 对重复列采用相加语义，其它与lj相同
  - union, uj; union和SQL中的语义相同，要求schema相同；uj schema可不相同，uj 同时会合并列
  - As-Of Join，采用less-than-or-equal作为join条件
  - window join，更为泛化的as-of join,可基于字段在某一范围作为join条件
- views, 使用::创建view,view本身保存的是table表达式
## 常用函数及操作符
- 字符串
  - 拆分/合并 vs/sv
  - 查找/替换 ss/ssr
  - 模糊查找 like ?（任意字符），*(任意数量任意字符)，[]（可能范围），^ （对[]取反）
  - ltrim/strim/trim
  - Tok，解析字符串 x$Y .e.g. "D"$"20200625"
- 排序 asc/desc
- 聚合函数 min/max/avg/sum/count
- 列表切分 cut
- 列表切片 sublist
- 集合操作，交/并/差 inter(inter 不是严格意义的集合操作，会有重复)/union/except
- 空值判断， null
- 真值逻辑 all/any/and/or
## 持久化
- Splayed Table
- Partitioned Table
- Segemaented Table
- Sym File
## 常用命令
- 加载q文件，\l
- 性能检测 \ts
- 暴露端口 \p
- 控制精度 \P
- 设置Timer \t
- 运行系统命令 system "command"
...
## 常见错误
- 'Length, 列表长度不匹配
- 'nyi 尚未实现（Nor yet implemented）
- 'os 操作系统错误
- 'type 类型错误
- 'rank 参数个数过多
...
