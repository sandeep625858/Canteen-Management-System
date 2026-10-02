package com.canteen.canteenms.HomeServiceAndDaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.canteen.canteenms.dao.UserListDao;
import com.canteen.canteenms.dao.UsersRepository;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.Users;
import com.canteen.canteenms.service.HomeServiceImpl;

@SpringBootTest
public class HomeServiceTests {
	
	 @InjectMocks
	    HomeServiceImpl service;
	 
	 @Mock
	 UserListDao userListdao;
	 
	 @Mock
	 UsersRepository users;
	     
	    
		@Test
	    public void testAddUser()
	    {
			List<UserList> list = new ArrayList<UserList>();
	        UserList userOne = new UserList(101,"Ankan","ankannath2012@gmail.com","Veg","ankan","ankan","active","ROLE_USER",1200);
	        
	        when(userListdao.save(userOne)).thenReturn(userOne);
	        when(userListdao.findAll()).thenReturn(list);
	          
	       list.add(service.addUser(userOne));
	          
	        
	          
	        //test
	        List<UserList> userList = service.getAllUser();
	          
	        assertEquals(1, userList.size());
	       verify(userListdao).findAll();
	    }
	    
	    
	    @Test
	    public void testAddUsers() {
	    	
	    	List<Users> list = new ArrayList<Users>();
	        Users userOne = new Users("ankannath2012@gmail.com","ankan","ROLE_USER");
	        
	        when(users.save(userOne)).thenReturn(userOne);
	        when(users.findAll()).thenReturn(list);
	        
	          
	       
	       list.add(service.addUsers(userOne));
	       
	          
	        
	          
	        //test
	        List<Users> usersList = service.getAllUsers();
	          
	        assertEquals(1, usersList.size());
	        verify(users).findAll();
	    	
	    	
	    }
	    

}
