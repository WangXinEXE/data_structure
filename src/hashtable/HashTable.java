package hashtable;

public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Emp emp = new Emp(1,"wx");
        Emp emp1 = new Emp(8,"wx1");

        hashTab.add(emp);
        hashTab.add(emp1);

        hashTab.list();

    }



}
//创建HashTable管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArr;
    private int size; //表示有多少条链表
    //构造方法
    public HashTab (int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];
        for(int i = 0;i < size;i++) {
            empLinkedListArr[i] = new EmpLinkedList();  //这块是很重要的,要给每一个链表都初始化,否则会空指针
        }
    }
    //添加方法(全局)
    public void add (Emp emp) {
        //先确定要添加到哪条链表
        int i = hashFun(emp.id);
        empLinkedListArr[i].add(emp);
    }
    //遍历所有的链表
    public void list() {
        for(int i = 0;i < size;i++) {
            empLinkedListArr[i].list();
        }
    }
    //简易版hash散列
    public int hashFun(int id) {
        return id % size;
    }

    public void findEmp(int id) {
        int i = hashFun(id);
        Emp emp = empLinkedListArr[i].findEmp(id);
        if(emp == null) {
            System.out.println("没有找到");
        } else {
            System.out.println(emp);
        }

    }

}


//emp属性
class Emp {
    public int id;
    public String name;
    public Emp next; //默认null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//EmpLinkedList
class EmpLinkedList {
    private Emp head;//默认null
    //假定id自增长,所以只要添加到链表最后一个即可
    public void add(Emp emp) {
        if(head == null) {
            head = emp;
            return;  // 你忘加这个了奥
        } else {
            Emp curEmp = head;
            while (true) {
                if(curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            curEmp.next = emp;  //我这之前写成curEmp = emp了,这是不对的,不要再犯这样的小错误,因为你的连接最后一个
        }
    }
    //遍历
    public void list() {
        if(head == null) {
            System.out.println("根本就没货");
            return;
        }
        Emp temp = head;
        while (true) {
            System.out.print(temp.id + "" + temp.name);
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
    //根据id查找
    public Emp findEmp(int id) {
        if(head == null) {
            System.out.println("找不了,空的");
            return null;
        }
        Emp temp  = head;
        while (true) {
            if(temp.id == id) {
                break;
            }
            if(temp.next == null) {
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }



}

