package General;

/**
 * Subject interface for the observer pattern
 * @author Daniel Tyebkhan
 */
public interface Subject {
	
	/**
	* Proper use: ttaches an Observer to an Object(subject)
	* @param Observer
	*/
	public void attachObserver(Observer obs);

	/**
	* Proper use: etaches an Observer to an Object(subject)
	* @param Observer
	*/
	public void detachObserver(Observer obs);

	/**
	* Proper use: Notifies all observers in subject
	*/
	public void notifyObservers();
}
