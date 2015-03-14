package org.agileware.screening;

public class Review {
	
	// we should use a more abstract collection type, like List or, better, Collection
	// and we should use generics as well: Collection<Device> is the best approach
	// what is *debug* used for? we should use system-wide environment configuration for this, and in this case seems not even necessary
	// in the entire method body I don't see any test for devices being offline....
	public LinkedList getOfflineDevicesForUser(User user, boolean debug) {
		// why do we create an ArrayList if we need a LinkedList? We should instantiate the result type here
		// The variable name is very badly chosen: what about *results* or *ownedDevices*?
		ArrayList l = new ArrayList();
		List allDevices = deviceRepository.getAll();
		// no need for the index, use the foreach construct here
		for (int x = 0; x < allDevices.size(); x++) {
			boolean found = false;
			List owners = ((Device) allDevices.get(x)).getOwners();
			// no need for this test, the for statement gets skipped anyway
			if (owners.size() > 0) {
				// no need for an index here, use the foreach statement
				for (int y = 0; y < owners.size(); y++) {
					// ERROR: it's *y* not *x*
					User owner = (User) owners.get(x);
					// no need for the *found* variable, add the owner directly to the results list
					// use *equals* not *==*, the objects might be different instances of the same user
					found = (owner == user);
				}
				// no need to test allDevices for null: it can never be, we are iterating over it
				if (found && allDevices != null)
					l.add(allDevices.get(x));
			}
		}
		// no need to create a new collection here, just use the right one from the beginning
		return new LinkedList(l);
	}
}
