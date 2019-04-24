package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class DaoImpl implements Idao {
	
	//unité de persistence
	EntityManagerFactory emf;
	
	//porteur de requête
	EntityManager em;

	@Override
	public int ajouterPersonne(Personne p) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.persist(p); // permet d'ajouter une personne p en BDD
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return p.getId();
	}

	
	@Override
	public Personne getPersonne(int id) {
	// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Personne p = new Personne();
			
			try {
				// effectuer la requete recuperer un id
				p = em.getReference(Personne.class, id);
				em.close();
				emf.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return p;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.remove(p); // permet de supprimer une personne p en BDD
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return p.getId();
	}

	@Override
	public int modifierPersonne(Personne p) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.merge(p); // permet d'ajouter une personne p en BDD
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return p.getId();
	}


	@Override
	public Personne affichagePersonne(int id) {
		// ouverture de l'unité de persistence
				// on a pas de transaction car ne modifie pas la BDD
					emf= Persistence.createEntityManagerFactory("demojpa-pu");
					em = emf.createEntityManager();
					Personne p = new Personne();
					
					try {
						// effectuer la requete recuperer un id
						p = em.find(Personne.class, id);
						em.close();
						emf.close();
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				return p;
	}


	@Override
	public List<Personne> findAllPErsonne() {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Query q= null;
			List<Personne> l = new ArrayList<Personne>();
			
			try {
				// effectuer la requete recuperer une liste
				q = em.createQuery("SELECT p FROM Personne p");
				l= q.getResultList();
				em.close();
				emf.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return l;
	}


	@Override
	public List<Personne> rechercherParMC(String mc) {
		// ouverture de l'unité de persistence
				// on a pas de transaction car ne modifie pas la BDD
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em = emf.createEntityManager();
				Query q= null;
				List<Personne> l = new ArrayList<Personne>();
					
				try {
				// effectuer la requete trouver un mot clé dans le nom et le prenom
				q = em.createQuery("SELECT p FROM Personne p where nom like :lenom and prenom like :leprenom");
				q.setParameter("lenom", "%"+mc+"%");
				q.setParameter("leprenom", "%"+mc+"%");
				l= q.getResultList();
				em.close();
				emf.close();
				} catch (Exception e) {
					e.printStackTrace();
						
				}
				return l;
	}


	@Override
	public int ajouterAdresse(Adresse a) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
				
		try {
		//1- débuter la transaction
		tx.begin();
					
		//2- effectuer la requête (on met ici toutes les opérations à effectuer)
		em.persist(a); // permet d'ajouter une adresse a en BDD
					
		//3- valider la transaction
		tx.commit();
		//4- fermer l'unité de persistence
		em.close();
		emf.close();
					
		} catch (Exception e) {
		// annuler la transaction 
			tx.rollback();
		}
				
		return a.getIdAdresse();
	}


	@Override
	public Adresse getAdresse(int idAdresse) {
	// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Adresse a = new Adresse();
					
			try {
			// effectuer la requete recuperer un id
			a = em.getReference(Adresse.class, idAdresse);
				em.close();
				emf.close();
			} catch (Exception e) {
				e.printStackTrace();
				}
				return a;
	}


	@Override
	public Adresse affichageAdresse(int idAdresse) {
	// ouverture de l'unité de persistence
	// on a pas de transaction car ne modifie pas la BDD
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Adresse a = new Adresse();
			
			try {
				// effectuer la requete recuperer un idAdresse
				a = em.find(Adresse.class, idAdresse);
				em.close();
				emf.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return a;
	}


	@Override
	public int supprimerAdresse(Adresse a) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.remove(a); // permet de supprimer une adresse
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}


	@Override
	public int modifierAdresse(Adresse a) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.merge(a); // permet d'ajouter une personne p en BDD
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}


	@Override
	public List<Adresse> findAllAdresse() {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Query q= null;
			List<Adresse> l = new ArrayList<Adresse>();
			
			try {
				// effectuer la requete recuperer une liste
				q = em.createQuery("SELECT a FROM Adresse a");
				l= q.getResultList();
				em.close();
				emf.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return l;
	}


	@Override
	public List<Adresse> rechercherAdresseParMC(String mcAdresse) {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q= null;
		List<Adresse> l = new ArrayList<Adresse>();
			
		try {
		// effectuer la requete trouver un mot clé dans le nom et le prenom
		q = em.createQuery("SELECT a FROM Adresse a where nomRue like :lenomrue and ville like :laville");
		q.setParameter("lenomrue", "%"+mcAdresse+"%");
		q.setParameter("laville", "%"+mcAdresse+"%");
		l= q.getResultList();
		em.close();
		emf.close();
		} catch (Exception e) {
			e.printStackTrace();
				
		}
		return l;
	}


	@Override
	public int ajouterConnexion(Connexion c) {
		// ouverture de l'unité de persistence et de la transaction
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
				
			try {
				//1- débuter la transaction
				tx.begin();
					
				//2- effectuer la requête (on met ici toutes les opérations à effectuer)
				em.persist(c); // permet d'ajouter une personne p en BDD
					
				//3- valider la transaction
				tx.commit();
				//4- fermer l'unité de persistence
				em.close();
				emf.close();
					
				} catch (Exception e) {
					// annuler la transaction 
					tx.rollback();
				}
				
				return c.getIdConnexion();
	}


	@Override
	public Connexion getConnexion(int idConnexion) {
		// ouverture de l'unité de persistence
			// on a pas de transaction car ne modifie pas la BDD
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em = emf.createEntityManager();
				Connexion c = new Connexion();
							
					try {
					// effectuer la requete recuperer un id
					c = em.getReference(Connexion.class, idConnexion);
						em.close();
						emf.close();
					} catch (Exception e) {
						e.printStackTrace();
						}
						return c;
	}


	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Connexion c = new Connexion();
				
				try {
					// effectuer la requete recuperer un id
					c = em.find(Connexion.class, idConnexion);
					em.close();
					emf.close();
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			return c;
	}


	@Override
	public int supprimerConnexion(Connexion c) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.remove(c); // permet d'ajouter une personne p en BDD
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}


	@Override
	public int modifierConnexion(Connexion c) {
		// ouverture de l'unité de persistence et de la transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1- débuter la transaction
			tx.begin();
			
			//2- effectuer la requête (on met ici toutes les opérations à effectuer)
			em.merge(c); // permet d'ajouter une personne p en BDD
			
			//3- valider la transaction
			tx.commit();
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annuler la transaction 
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}


	@Override
	public List<Connexion> findAllConnexion() {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Query q= null;
			List<Connexion> l = new ArrayList<Connexion>();
			
			try {
				// effectuer la requete recuperer une liste
				q = em.createQuery("SELECT c FROM Connexion c");
				l= q.getResultList();
				em.close();
				emf.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return l;
	}


	@Override
	public List<Connexion> rechercherConnexionParMC(String mcConnexion) {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q= null;
		List<Connexion> l = new ArrayList<Connexion>();
			
		try {
		// effectuer la requete trouver un mot clé dans le nom et le prenom
		q = em.createQuery("SELECT c FROM Connexion c where login like :lelogin and mdp like :lemdp");
		q.setParameter("lelogin", "%"+mcConnexion+"%");
		q.setParameter("lemdp", "%"+mcConnexion+"%");
		l= q.getResultList();
		em.close();
		emf.close();
		} catch (Exception e) {
			e.printStackTrace();
				
		}
		return l;
	}


	@Override
	public List<Personne> findAllPersonnesConnexion() {
		// ouverture de l'unité de persistence
			// on a pas de transaction car ne modifie pas la BDD
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em = emf.createEntityManager();
				Query q= null;
				List<Personne> l = new ArrayList<Personne>();
					
				try {
					// effectuer la requete recuperer une liste
					q = em.createQuery("SELECT p FROM Personne p left join p.connexion");
					l= q.getResultList();
					em.close();
					emf.close();
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				return l;
	}


	@Override
	public List<Personne> findAllPersonnesAdresse() {
		// ouverture de l'unité de persistence
		// on a pas de transaction car ne modifie pas la BDD
			emf= Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			Query q= null;
			List<Personne> l = new ArrayList<Personne>();
				
			try {
				// effectuer la requete recuperer une liste
				q = em.createQuery("SELECT p FROM Personne p left join p.adresse");
				l= q.getResultList();
				em.close();
				emf.close();
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			return l;
	}

}
