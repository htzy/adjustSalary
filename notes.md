# 笔记
1. valueOf 和parseDouble的区别 
- `Double r = Double.valueOf(sts[1]);`
- valueOf返回对象，而parseDouble返回值
- 高性能的程序使用double值，而框架希望使用Double对象，因为对象可以暂时不赋值，为null

2. 分割字符串
- `sts[0].substring(1, sts[0].length());`
- `//首先把第一个{去掉，再把所有的分隔符用;+分隔符隔开，但是要注意第一个元素可能为""空字符串，再用;分号分割`<br>
`st.replace("{", "").trim().replace("&", ";&").replace("|", ";|").replace("!", ";!").split(";");`

3. 使用泛型T或Object
- 因为java泛型不彻底，所以可以直接用Object<br>


    public double getRate<T>(T t) {...}
    double rate = rule.getRate<Staff>(staff);

4. TreeSet


    TreeSet<String> tSet = new TreeSet<String>();
    tSet.add("1");
    tSet.add("2");
    tSet.add("3");
    tSet.add("4");
    tSet.add("5");
    System.out.println("Lowest value Stored in Java TreeSet is : " + tSet.first());
    System.out.println("Highest value Stored in Java TreeSet is : " + tSet.last());

5.
