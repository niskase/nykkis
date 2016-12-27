package nykkis.nykkis_demo;

public class Status {

	 private int status_id;
	 private char status_name;
	 

public void setStatus_id(int status_id){
		this.status_id=status_id;
}
public int getStatus_id(){
	return status_id;
}
public void setStatus_name(char status_name){
	this.status_name= status_name;
}
public char getStatus_name(){
	return status_name;
}
@Override
public String toString() {
	return "Status [status_id=" + status_id + ", status_name=" + status_name
			+ "]";
}


}
