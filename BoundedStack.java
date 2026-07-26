import java.util.ArrayList;
import java.util.List;

/**
 * พีรณัฐ ทำสวน 6821601321
 * วัสมพล เครืออารีย์ 6821601437
 * 
 * BoundedStack is .....
 */

public class BoundedStack {
    private final List<String> elements;
    private final int capacity;
   //AF(elements,capacity)
   //RI
   //-
   //-
   
   
   
    /**
     * 
     * @param รับหนังสือไม่เกิน10เล่ม
     * @return เมื่อรับหนังสือครบให้หยิบไปที่เล่มแรก
     * @throws แจ้งเตือนเมื่อหนังสือมีค่า = Null
     */
    public BoundedStack(int capacity){
        this.elements = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * 
     * @param เพิ่มหนังสือเมืื่อมีค่าน้อยกว่า10
     * @return 
     * @throws แจ้งเตือนเมื่อหนังสือเต็ม
     */
    public void push(String s){


    }

    
    
}

