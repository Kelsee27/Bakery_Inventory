//Kelsee Carmichael T00632621

import java.util.*;

public class Shelf{
 
 private Stack<Object> stack;

 public Shelf()
 {
  this.stack = new Stack<Object>();
  }
 
 public void addItem(Product a)
 {
  stack.push(a);
 }
 
 public Object sellItem()
 {
  return stack.pop();
 }
 
 public Stack<Object> printStack()
 {
  if (stack.isEmpty()) 
  {
    return null;
  }
  else
  {
    return stack;
  }

 }
 
}
