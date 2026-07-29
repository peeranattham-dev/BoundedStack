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
        System.out.println("== BoundedStack Test==\n");
        
        {
            //เช็ค peek ตอน stack ว่าง
            BoundedStack sapce = new BoundedStack(3);
            boolean threw = false;
            try {
                sapce.peek();
            } catch (IllegalStateException e) {
                threw =true;
            }
            check("stack ว่างแล้ว peek ต้อง throw IllegalStateException", threw);
        }

        {
            // เช็คcapacity = -1
            boolean threw  = false;
            try {
                new BoundedStack(-1);
            } catch (IllegalArgumentException e) {
                threw = true;
            }
           check("new(-1) ต้อง throw IllegalArgumentException", threw);
        }

        {
            // capacity ปกติ ต้องสร้างได้
            BoundedStack s = new BoundedStack(3);
            check("new(3) ควรสร้างได้ปกติ", true);
        }

        {
            // capacity = 1 ต้องสร้างได้ (ต่ำกว่านี้ต้องโดนปฏิเสธ)
            BoundedStack one = new BoundedStack(1);
            check("new(1) ควรสร้างได้ (ค่าต่ำสุดที่ยังสร้างสำเร็จ)", true);
        }

        {
            // capacity = 10 ต้องสร้างได้ (มากกว่านี้ต้องโดนปฏิเสธ)
            BoundedStack max = new BoundedStack(10);
            check("new(MAX_BOOKS) ควรสร้างได้ (ค่าสูงสุดที่ยังสร้างสำเร็จ)", true);
        }

        {
            // capacity < 1 จะโดนปฏิเสธ
            boolean threw = false;
            try {
                new BoundedStack(0);
            } catch (IllegalArgumentException e) {
                threw = true;
            }
            check("new(0) ต้อง throw IllegalArgumentException", threw);
        }
        
        System.out.println("\n=== Summary ===");
        System.out.println("Pass: " + pass);
        System.out.println("Fail: " + fail);
        System.out.println("Total: " + (pass + fail));

        
    }
}