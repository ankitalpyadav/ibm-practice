package com.ibm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Ticket {
		@Id
		private int pnr;
		private LocalDate date;
		private double amount;
	
		@OneToMany(mappedBy = "tickets", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		private List<Passenger> psngr;
		

		public List<Passenger> getPsngr() {
			return psngr;
		}

		public void setPsngr(List<Passenger> psngr) {
			this.psngr = psngr;
		}

		public Ticket() {
		}

		public Ticket(int pnr, LocalDate date, double amount) {
			super();
			this.pnr = pnr;
			this.date = date;
			this.amount = amount;
		}

		public int getPnr() {
			return pnr;
		}

		public void setPnr(int pnr) {
			this.pnr = pnr;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Ticket [pnr=" + pnr + ", date=" + date + ", amount=" + amount + "]";
		}

		
		
		
}
