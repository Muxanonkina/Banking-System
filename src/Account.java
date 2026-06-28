public abstract class Account implements FinancialOperation {
private String name;
private String sureName;
private String tel;
private String gmail;

protected Account(String name , String sureName,String tel, String gmail){
 this.name = name;
 this.sureName = sureName;
  this.tel = tel;
  this.gmail = gmail;
 }

 public Account() {

 }

 protected String getName(){
  return name;
 }
 protected String getSureName(){
 return  sureName;
 }
 protected String getTel(){
 return tel;
 }
 protected String getGmail(){
 return gmail;
 }

 public void setName(String name){
 if(name != null && !name.isEmpty()){
  this.name = name;
 }
 }

 public void setSureName(String sureName){
 if(sureName != null && !sureName.isEmpty()){
  this.sureName = sureName;
 }
 }

 public void setTel(String tel){
 this.tel = tel;
 }

 public void setGmail(String gmail){
 this.gmail = gmail;
 }

 public void ShowInfo(){
 System.out.println("Name: " + getName());
 System.out.println("SureName: " + getSureName());
 System.out.println("Phone: " + getTel());
 System.out.println("Gmail: " + getGmail());
 System.out.println("=======================");
 }



 abstract void showAccountType();

}
