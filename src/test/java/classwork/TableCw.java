//package classwork;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//public class TableCw {
//        WebElement table;
//        public TableCw(WebElement table) {
//            this.table = table;
//        }
//
//        public int getRowsCount() {
//            return table.findElement(By.tagName("tr")).get();
//        }
//
//        public int getColumnCount() {
//            return table.findElement(By.tagName("tr")).findElement(By.tagName("th")).size();
//        }
//
//        public WebElement getCell(int x, int y) {
//            WebElement row = table.findElement(By.tagName("tr")).get(x);
//            WebElement cell;
//            if (y ==0) {
//                cell = row.findElement(By.tagName("th")).get(y);
//            } else {
//                cell = row.findElement((By.tagName("td")).get(y));
//            }
//            return cell;
//        }
//}
//
