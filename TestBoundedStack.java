/**
 * Test runner for BoundedStack
 * 
 */
public class TestBoundedStack {
    static int pass = 0, fail = 0;

     static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }
 
    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestBoundedStack **");
        System.out.println("== BoundedStack ==");

        {
        //เช็คสร้างcapacity
            BoundedStack sapce = new BoundedStack(3);
            boolean threw = false;
            try {
                sapce.peek();
            } catch (IllegalStateException e) {
                threw =true;
            }
            check("capacity = 3", threw);
        }
        {//เช็คcapacity = -1
            boolean threw  = false;
            try {
                new BoundedStack(-1);
            } catch (IllegalArgumentException e) {
                threw = true;
            }
           check("capacity = -1", threw);
        }
    }
}