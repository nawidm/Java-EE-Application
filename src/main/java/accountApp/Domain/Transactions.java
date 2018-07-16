package accountApp.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Transactions {

	    @Id @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    @Column (length = 100)
		private String tName;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ACCOUNT_ID")
	    private Account account;
}