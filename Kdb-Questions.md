# 初级
## 特性
1. 简述列存储的优势？ 参考答案： 1. 列存储便于作压缩以进行高效存储； 2. OLAP关心列的特征，以列为存储使计算更为高效
2. 对于持久化到的磁盘的表，比如splayed的表，执行query时（比如取最后一条数据）会直接基于磁盘作查询操作吗？
  参考答案：kdb所有查询操作都是基于内存，只有对内存的操作
3. q支持闭包（词法作用域）吗，function所能访问到的变量作用域有哪些？ 参考答案： 不支持；参数、局部变量、全局变量

## 数据类型
1. "Hello" 与 `Hello有什么区别？ 参考答案：数据类型不同，双引号包括的是list类型，且其list中元素是基本类型char，反引号是symbol类型，不可分割，是基本数据类型； 
2. 如何将"Hello"转型为`Hello?  
  参考答案：
  - 转型：``` `$"Hello" ```
  - Tok： ``` "S"$"Hello" ```

3. 何时采用symbol而不是char list？ 参考答案： symbol是一种优化手段，当该列值取值在某个固定的列表中且大量重复出现，适合用symbol,e.g. ticker
4. 如何查看给定table t的列定义？ 参考答案： meta t
5. kdb是如何存储日期相关类型的，有什么好处？ 参考答案：以数值类型存储，以2000.01.01为起点，之前为负数，之后为正数；日期相关操作实际转换为数字的基本运算
6. Keyed Table的数据类型是什么？ 答案： Dictionary

## Iterators(Adverbs)
1. 给定l: 1 2 3, 要求使用each left \:语法得到2 * 3的新list,第一列为3 6 9，第二列为5 10 15？参考答案: 3 5 *\: 1 2 3
2. scan和over的区别是什么？ 参考答案： scan 结果为与source长度相同的list,是中间结果的值，over是最终结果值
3. peach与each的区别，是线程级别还是进程级别并行？ 参考答案： peach是并行版本，根据启动参数不同，若-s跟的是正数，则kdb启动相应数量线程，为负则是进程，由用户指定工作进程

## q-sql
1. 使用select by时若没有指定聚合函数，每列的值是什么？ 答案： 如果没有写select内容，或取group里的last作为列的值
2. exec与select的区别？参考答案： select返回的始终是表结构，exec可以是list/scalar等
3. t1, t2都是以id作key的表，且列不完全相同，id类型相同；t1,t2都是普通表，列不完全相同，但都有相同类型的id列；两者是否能做uj，结果是什么？  
参考答案： 都可以作uj；都是keyed表，新表列是两者的并集，行执行upsert语义（右覆盖左）；都是普通表，新表列是两者并集，行是作concat
4. select的结果，对于某一列的每一行，是否可以是复杂结构（比如table）？ 答案： 可以
5. ej与ij有什么区别？ 参考答案：ej不要求右表为keyed table，右表作为join 的列有重复值时在结果中仍然存在，ej等价于sql里的inner join语义
6. 作ij或lj时，左右两表有相同的列名时，比如t1有id,name两列，t2也有id,name两列，并且t2以id为key，执行t1 ij t2, 对于id相同的行，name取什么值，为什么？参考答案：取t2 name的值，因为采用的是upsert语义
7. 给定表结构
```
t:([] closeDate:`date$(); limit:`int$(); batchNumber:`int$())
t,: ([] closeDate:(2020.06.07 2020.06.07 2020.06.07 2020.06.07 2020.06.08); limit:10 1 2 -1 5; batchNumber:1 2 2 2 1)

每个closeDate会有多个batch,batchNumber标示，逐次递增，每个batch包含多条limit记录，limit有正有负，limit正加和为LimitLong，负加和为TriggerShort
求每个closeDate最新batch的LimitLong和TriggerShort
```
参考答案：
```
select LimitLong: sum(limit[where limit > 0]), TriggerShort: sum(limit[where limit < 0]) by closeDate from (select from t where batchNumber=(max; batchNumber) fby closeDate)
closeDate | LimitLong TriggerShort
----------| ----------------------
2020.06.07| 3         -1          
2020.06.08| 5         0
```

## 常用函数及操作符
1. 如何将long 列表 1 2 3，转换成逗号分割的字符串"1,2,3"? 参考答案： "," sv string 1 2 3
2. 如何找出name列中包含citi的所有行？ 参考答案： name like "*citi*"
3. 如何取两个list的交集？ 参考答案： distinct (l1 inter l2)

## 持久化
1. Splayed Table主要解决了什么问题？ 参考答案： splayed table中每一列都单独存储，只会加载用到的列，对于列很多，但query只用到部分列时，减少了加载不必要列到内存的过程
2. Patitioned Table与Splayed Table区别与联系？ 参考答案：Patitioned Table一定是Splayed的，Partitioned Table是在Splayed的基础上，对行作划分，比如以日期列作partition,具有相同日期列的所有行将归到同一partition；在query partition表时，要在where第一个子句中指定partition，这样只会处理相应partition
3. Sym File的作用？ 参考答案：所有Splayed的table中存储的symbol类型数据都是在SymFile上的偏移量，通过索引SymFile才能得到实际的值

## 常用命令
1. \ts 返回结果代表意义？ 答案：返回为长度为2的整型list，第一个值是运行的时间开销（ms）,第二个值是空间开销（bytes）
2. kdb有什么机制来执行定时任务？ 参考答案： 设置timer  \t
3. kdb能否运行宿主OS的命令，比如ls， curl等？ 参考答案：运行系统命令 system "command"

## 常见错误
1. 运行报'Length是什么原因？ 参考答案： 列表长度不匹配
2. 运行报'type是什么原因？ 参考答案： 类型错误