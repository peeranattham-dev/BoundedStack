import java.util.ArrayList;
import java.util.List;

/**
 * พีรณัฐ ทำสวน 6821601321
 * วัสมพล เครืออารีย์ 6821601437
 * 
 * BoundedStack is
 * 
 */

public class BoundedStack {
    private final List<String> Books;
    private final int capacity;
   //AF(Books,capacity)
   //RI
   //
   //
   //
   
   
   
    /**
     * สร้าง BoundedStack ที่มีความจุตามที่กำหนด
     * 
     * @param capacity จำนวนหนังสือสูงสุดที่เก็บได้ 10 เล่ม
     * @throws IllegalArgumentException ถ้า capacity <= 0
     */
    public BoundedStack(int capacity){
        this.Books = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * ตรงนี้คือการเพิ่มหนังสือไว้บนสุดของชั้นรับคืน
     * @param book ชื่อหนังสือที่ต้องการคืน
     * @throws IllegalArgumentException ถ้า book เป็น null
     * @throws IllegalStateException ถ้าชั้นรับคืนเต็ม
     */
    public void push(String book){


    }


    /**
     * ตรงนี้คือการหยิบหนังสือบนสุดออกจากชั้นรับคืนหนังสือ
     * @return หนังสือถูกหยิบออก
     * @throws IllegalStateException ถ้าชั้นรับคืนว่าง
     * 
     */
    public String pop() {
        return null;
    }
    
    
    
}

