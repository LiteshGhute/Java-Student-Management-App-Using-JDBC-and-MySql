import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.student.manage.*;

public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("App is running");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add user");
			System.out.println("Press 2 to Delete user");
			System.out.println("Press 3 to display user");
			System.out.println("Press 4 to exit app");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add user
				System.out.println("Enter user name");
				String name = br.readLine();
				
				System.out.println("Enter user Phone");
				String phone = br.readLine();
				
				System.out.println("Enter user city");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				
				boolean answer = StudentDao.insertStudentToDB(st);
				
				if(answer) {
					System.out.println("User Added Successfully");
				}else {
					System.out.println("User add failed");
				}
				
			}else if(c==2) {
				//delete user
				System.out.println("Enter Student id to delete");
				int id = Integer.parseInt(br.readLine());
				boolean answer = StudentDao.deleteStudent(id);
				
				if(answer) {
					System.out.println("User deleted Successfully");
				}else {
					System.out.println("User delete failed");
				}
				
			}else if(c==3) {
				//display user
				StudentDao.showAllStudents();
				
			}else if(c==4) {
				//exit
				break;
			}else {
				continue;
			}
			
			System.out.println("App running stopped");
		}
	}

}
