import java.util.Scanner; 
class network{
    int time;
    String value;
    boolean possible; 
}
class main{
    Random rand = new Random();
    ArrayList<network> list=new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    System.out.println("enter how many packets you want to send");
    int n=sc.nextInt();
    System.out.println("Enter packet information");
    for(int i=0;i<n;i++)
    {
       
        System.out.println("Enter Packet time");
        int time=sc.nextint();
        System.out.println("Enter Packet value");
        String val=sc.nextLine();
        System.out.println("Enter Packet possible");
        boolean possible=sc.nextBoolean();
        list.add(new network( time,val,possible));
    }
    Collections.sort(list,(l1,l2)->l1.time-l2.time);
    String ans=""
    for(int i=0;i<list.size();i++)
        ans+=list.get(i).value+" ";
    return ans;
}