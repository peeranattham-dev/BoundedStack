/**
 * Test runner for BoundedStack
 * 
 */
public class TestBoundedStack {
    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) {
            pass++;
            System.out.println("  [PASS] " + name);
        } else {
            fail++;
            System.out.println("  [FAIL] " + name);
        }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea)
            System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestBoundedStack **");
        System.out.println("== BoundedStack Test==\n");

        // เพิ่มfuntion
        testCreators();
        testPush();
        testPop();
        testPeek();

        System.out.println("\n=== Summary ===");
        System.out.println("Pass: " + pass);
        System.out.println("Fail: " + fail);
        System.out.println("Total: " + (pass + fail));
    }

    private static void testCreators() {
        System.out.println("-- Creators --");

        {
            // เช็ค peek ตอน stack ว่าง
            BoundedStack sapce = new BoundedStack(3);
            boolean threw = false;
            try {
                sapce.peek();
            } catch (IllegalStateException e) {
                threw = true;
            }
            check("stack ว่างแล้ว peek ต้อง throw IllegalStateException", threw);
        }
        {
            // เช็คcapacity = -1
            boolean threw = false;
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

    }

    private static void testPush() {
        System.out.println("\n-- Push --");

        {
            // พิมพ์ค่าไหนต้องออกค่านั้น
            BoundedStack s = new BoundedStack(3);
            s.push("A");
            check("push(A) แล้ว peek ต้องได้ A", s.peek().equals("A"));
        }
        {
            // ถ้าไม่ใส่อะไรเลยต้องโยน throw IllegalArgumentException
            BoundedStack s = new BoundedStack(3);
            boolean threw = false;
            try {
                s.push(null);
            } catch (IllegalArgumentException e) {
                threw = true;
            }
            check("push(null) ต้อง throw IllegalArgumentException", threw);
        }
        {
            // ถ้าใส่ค่าจนเต็ม MAX_BOOKS พอดีจะทำงานได้ปกติ
            BoundedStack s = new BoundedStack(2);
            s.push("A");
            s.push("B");
            check("push จนเต็มพอดีต้องทำงานได้ปกติ", s.peek().equals("B"));
        }
        {
            // ถ้าใส่ค่าตอน stack เต็มจะ throw IllegalStateException
            BoundedStack s = new BoundedStack(2);
            s.push("A");
            s.push("B");
            boolean threw = false;
            try {
                s.push("C");
            } catch (IllegalStateException e) {
                threw = true;
            }
            check("push ตอน stack เต็มแล้ว ต้อง throw IllegalStateException", threw);
        }
    }

    private static void testPop() {
        System.out.println("\n-- Test POP --");
        {
            // ถ้าstack ว่าง จะ throw IllegalStateException
            BoundedStack s = new BoundedStack(3);

            boolean threw = false;
            try {
                s.pop();
            } catch (IllegalStateException e) {
                threw = true;
            }
            check("pop ตอนstack ว่างจะ throw IllegalStateException  ", threw);
        }
        {
            // มี1เล่มต้องpopให้เล่มนั้น
            BoundedStack s = new BoundedStack(3);
            s.push("A");
            check("pop หลัง push  1 เล่ม ได้ค่าตรง", s.pop().equals("A"));
        }
        {
            // มีหลายเล่มต้องPOP ตามลำดับเข้าสุดท้ายออกก่อน Last in Ftist Out
            BoundedStack s = new BoundedStack(3);
            s.push("A");
            s.push("B");
            s.push("C");
            boolean LIFO = s.pop().equals("C") && s.pop().equals("B") && s.pop().equals("A");
            check("pop เรียงลำดับ last in Frist out", LIFO);
        }
        {
            // pop ต้องเอาเล่มออกจริง ไม่ใช่แค่คืนค่าเฉยๆ (ต่างจาก peek)
            BoundedStack s = new BoundedStack(3);
            s.push("A");
            s.push("B");
            s.pop();
            check("pop แล้วเล่มถูกเอาออกจริง เหลือแค่ A", s.peek().equals("A"));

        }
        {
            BoundedStack s = new BoundedStack(3);
            s.push("A");
            s.push("B");
            s.pop();
            s.pop();
            boolean threw = false;
            try {
                s.pop();
            } catch (IllegalStateException e) {
                threw = true;
            }
            check("pop จนว่างแล้ว pop ซ้ำต้อง throw", threw);
        }
        {
            // pop แล้วมีที่ว่าง -> push กลับเข้าไปได้อีกจนเต็ม capacity เดิม
            BoundedStack s = new BoundedStack(2);
            s.push("A");
            s.push("B");
            s.pop();
            s.pop();

            boolean PushAfterPop = true;
            try {
                s.push("c");
            } catch (IllegalStateException e) {
                PushAfterPop = false;
            }
            check("pop แล้วมีที่ว่างให้ push กลับเข้าไปได้", PushAfterPop);
        }
    }

    private static void testPeek() {
         System.out.println("\n-- Test PEEK --");
        
         {
         //stack ว่างให้throw
         BoundedStack s = new BoundedStack(2);
         boolean threw = false;
         try {
            s.peek();
         } catch (IllegalStateException  e) {
            threw = true;
         }
         check("peek stack ว่างต้อง throw IllegalStateException", threw);
         }
         //มี1เล่มต้องได้เล่มนั้น
         {
            BoundedStack s = new BoundedStack(2);
            s.push("A");
            check("peek หลัง push 1 เล่ม ได้ค่าตรง", s.peek().equals("A"));
         }
         //ต้อง peekได้เล่มบนสุดเท่านั้น(ล่าสุด)
         {
            BoundedStack s = new BoundedStack(3);
            s.push("A");
            s.push("B");
            s.push("C");
            check("peek ได้เล่มบนสุด (ล่าสุด)", s.peek().equals("C"));
         }
         //Pop จนว่างแล้ว Peek ต้อง throw อีกรอบ
         {
            BoundedStack s = new BoundedStack(2);
            s.push("A");
            s.pop();
            boolean threw =  false;
            try {
                s.peek();
            } catch (IllegalStateException  e) {
                threw = true;
            }
            check("peek หลัง pop จนว่างต้อง throw อีกครั้ง", threw);
         }
         
    }

}
