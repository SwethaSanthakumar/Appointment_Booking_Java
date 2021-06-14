public class Staff{ 
public String staffName;
public String staffPassword;
public long staffMobileNo;
public String staffEmail;
public String staffAccess;
public Staff(){}
public Staff(String staffPassword,long staffMobileNo,String staffEmail, String staffAccess) {      
this.staffPassword = staffPassword;    
this.staffMobileNo = staffMobileNo;
this.staffEmail=staffEmail;
this.staffAccess=staffAccess;    }
@Override
public String toString() {
return new StringBuffer("").append(this.staffPassword).append(",").append(this.staffMobileNo).append(",").append(this.staffEmail).append(",").append(this.staffAccess)
.toString();
}  }