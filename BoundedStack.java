import java.util.ArrayList;
import java.util.List;

/**
 * พีรณัฐ ทำสวน 6821601321
 * วัสมพล เครืออารีย์ 6821601437
 * 
 * BoundedStack — ADT แทนชั้นรับคืนหนังสือของห้องสมุด
 * 
 * หนังสือจะถูกวางซ้อนกัน และหยิบออกจากด้านบนสุดก่อน
 * (ใช้เป็นชั้นคืนหนังสือเพื่อให้เป็นภาพง่ายๆ)
 * 
 */

public class BoundedStack {
    public static final int MAX_BOOKS = 10;
    private final List<String> books;
    private final int capacity;
    
    
    //Abstraction Function:
    //AF(Books,capacity)  
    //    สแตกของหนังสือ โดยเรียงจากล่างขึ้นบนตามตำแหน่ง 0, 1, ..., books.size()-1 ใน books                      
    //    ซึ่ง books.get(books.size()-1) คือหนังสืออยู่บนสุด (จะถูกหยิบออกก่อนด้วย pop/peek)                   
    //    และ capacity คือจำนวนหนังสือสูงสุดที่ชั้นรับคืนนี้เก็บได้
    
    //Representation Invariant:
    //    -books ต้องไม่เป็นค่าว่าง
    //    -capacity ต้องมากกว่า 0 และไม่เกิน MAX_BOOKS
    //    -จำนวนหนังสือที่เก็บอยู่ใน books ต้องไม่เกิน capacity
    //    -ทุก element ใน books ต้องไม่เป็น null

        
    //  ===== Checkrep =====
    private void checkRep(){
        assert books != null;
        assert capacity > 0 && capacity <= MAX_BOOKS : "capacity ต้องอยู่ในช่วง 1 ถึง " + MAX_BOOKS;
        assert books.size() <= capacity;
        for (String book : books){
            assert book != null;
        }
    }


    //  ===== Creator =====
    /**
     * สร้าง BoundedStack ที่มีความจุตามที่กำหนด
     * 
     * @param capacity จำนวนหนังสือสูงสุดที่ stack เก็บได้
     * @throws IllegalArgumentException ถ้า capacity <= 0
     */
    public BoundedStack(int capacity) {
        if (capacity <= 0 || capacity > MAX_BOOKS)
            throw new IllegalArgumentException();
        this.books = new ArrayList<>();
        this.capacity = capacity;
        checkRep();
    }


    //  ===== Mutators เพิ่มสมาชิก=====
    /**
     * เพิ่มหนังสือไว้บนสุดของชั้นรับคืนหนังสือ
     * 
     * @param book ชื่อหนังสือที่ต้องการจะคืน
     * @throws IllegalArgumentException ถ้า book เป็น null
     * @throws IllegalStateException    ถ้า stack เต็ม
     */
    public void push(String book) {
        if (book == null)
            throw new IllegalArgumentException();

        if (books.size() == capacity)
            throw new IllegalStateException();

        books.add(book);
        checkRep();
    }


    //  ===== Mutators 2 ลบสมาชิกตัวบนสุด =====
    /**
     * หยิบหนังสือบนสุดออกจากชั้นรับคืนหนังสือ
     * 
     * @return หนังสือถูกหยิบออกจากด้านบนสุด
     * @throws IllegalStateException ถ้า stack ว่าง
     * 
     */
    public String pop() {
        if (books.isEmpty())
            throw new IllegalStateException();
        String result = books.remove(books.size() - 1);
        checkRep();
        return result;  
    }


    //  ===== Observers =====
    /**
     * เรียกดูหนังสือบนสุดของชั้นรับคืนหนังสือ
     *
     * @return หนังสือบนสุดของ Stack
     * @throws IllegalStateException ถ้า stack ว่าง
     */
    public String peek() {
        if (books.isEmpty())
            throw new IllegalStateException();
        return books.get(books.size() - 1);
    }


    //  ===== Producer =====
    /**
     * สร้าง BoundedStack ใหม่ที่มีหนังสือเหมือนกับ stack นี้
     * 
     * @return BoundedStack ใหม่ที่copyมาจากของ stack นี้
     */
    public BoundedStack copy() {
        BoundedStack newStack = new BoundedStack(this.capacity);
        for (int i = 0; i < books.size(); i++) {
            newStack.books.add(books.get(i));
        }
        newStack.checkRep();
        return newStack;

    }
}
