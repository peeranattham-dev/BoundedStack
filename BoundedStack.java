import java.util.ArrayList;
import java.util.List;

/**
 * พีรณัฐ ทำสวน 6821601321
 * วัสมพล เครืออารีย์ 6821601437
 * 
 * BoundedStack — ADT แทนชั้นรับคืนหนังสือของห้องสมุด
 * 
 * หนังสือจะถูกวางซ้อนกัน และหยิบออกจากด้านบนสุดก่อน
 * 
 */

public class BoundedStack {
    private final List<String> books;
    private final int capacity;
   //AF(Books,capacity)
   //RI
   //
   //
   //
   
   
   
    /**
     * สร้าง BoundedStack ที่มีความจุตามที่กำหนด
     * 
     * @param capacity จำนวนหนังสือสูงสุดที่ stack เก็บได้
     * @throws IllegalArgumentException ถ้า capacity <= 0
     */
    public BoundedStack(int capacity){
        this.books = new ArrayList<>();
        this.capacity = capacity;
    }



    /**
     * เพิ่มหนังสือไว้บนสุดของชั้นรับคืนหนังสือ
     * 
     * @param book ชื่อหนังสือที่ต้องการจะคืน
     * @throws IllegalArgumentException ถ้า book เป็น null
     * @throws IllegalStateException ถ้า stack เต็ม
     */
    public void push(String book){

    }



    /**
     * หยิบหนังสือบนสุดออกจากชั้นรับคืนหนังสือ
     * 
     * @return หนังสือถูกหยิบออกจากด้านบนสุด
     * @throws IllegalStateException ถ้า stack ว่าง
     * 
     */
    public String pop() {
        return null;
    }

    
    
    /**
    * เรียกดูหนังสือบนสุดของชั้นรับคืนหนังสือ
    *
    * @return หนังสือบนสุดของ Stack
    * @throws IllegalStateException ถ้า stack ว่าง
    */
    public String peek() {
        return null;
}
    
    
    
}

