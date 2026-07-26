import java.util.ArrayList;
import java.util.List;

/**
 * พีรณัฐ ทำสวน 6821601321
 * วัสมพล เครืออารีย์ 6821601437
 * 
 * BoundedStack is .....
 */

public class BoundedStack {
    private final List<String> Books;
    private final int capacity;
   //AF(Books,capacity)
   //RI
   //-
   //-
   
   
   
    /**
     * 
     * @param ชั้นรับคืนหนังสือมีพื้นที่10เล่ม
     * @return เมื่อชั้นหนังสือเต็ม return = -1
     * @throws แจ้งเตือนเมื่อหนังสือมีค่า = -1
     */
    public BoundedStack(int capacity){
        this.Books = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * 
     * @param เพิ่มหนังสือเมื่อมีค่าน้อยกว่า10
      
     * @throws แจ้งเตือนเมื่อหนังสือเต็ม
     */
    public void push(String book){


    }


    /**
     * 
     * @param บรรณารักษ์หยิบหนังสือออกจากชั้นวางหนังสือ
     * @return หนังสือถูกหยิบออก
     * @throws แจ้งเตือนว่าหนังสือถูกหยิบซ้ำ
     * 
     */
    public void pop(String book){

    }

    
    
}

