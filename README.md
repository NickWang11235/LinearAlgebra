# Linear-Algebra
A mini Computer Algebra System (CAS) that performs matrix related operations.

## Version Control for Developers -7/6/2019
 
Development should follow the below branching protocal:
  * The git repo will now have two branches at all times: master and development. They should not be deleted under any conditions.
  * The master branch will only contain bug-free, completed code. Any version on this branch should be considered final. Merge to
    master should only occur when features are completely implemented, additionally any merge to master should be complimented by a 
    new tag.
  * The development branch will contain work-in-progress. Any version on this branch should be compile-time error free, completed,
    but with non-final features. Merge to development branch should only occur when code is finished but yet to be tested for 
    compatibility and run-time errors.
  * Any addition, deletion, or modification of code should be completed on a seperate branch that branched off the development branch.
    The seperate branch can be modified at will by any developers, this branch should not be pushed to the server unless needed for        collaboration, and deleted afterwards. 
  * A graph is provided below to visualize the process.

<pre>
    (initla code)										 (version 1)
	master 						----> 					   master
	     \										  	    /(merge)
      (branch)\   (initial code)   	       (incompatibility issue found)  /--->   	development/
	       \   development  	 	---->	development	 ----/	  (updated compatible code)
	            \    \			      /   /	   \		            /
                     \    \(branch)	     (merge) /   /	    \(branch)	           /(merge)
	      (branch)\    \     feature 1 ---->    /   /(merge)     \	 Issue1  ---->    /
		       \(development and debugging)    /	    (fix compatibility issue)
		        \                             /
		         \       feature 2   ---->   /
		           (development and debugging)
</pre>

DISCLAIMER: Person who wrote this READ-ME is a retarded noob. He has a small penis. Tiny.
