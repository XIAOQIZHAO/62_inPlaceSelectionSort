# in-place selection sort

Rearrange
an unordered `ArrayList<Integer>`
and use it as the data in an `OrderedList_inArraySlots`.

The re-use is probably contrary to Java's conventions
for its built-in classes. But as a pedagogical tool,
it has the advantage of allowing
the User program to check that the sort
is done in-place.

## count the cost

0. If the number of the elements in the input triples,
the time required to run the reigning champ algorithm
will ___triple________.
Justification:
The Algorithm requires looking at every element.


0. If the number of the elements in the input triples,
the number of times that the reigning champ algorithm
will be invoked 
will ______triple________.
Justification:
The algorithm is invoked once for each slot in the array to fill the slot. Each invocation fills one slot.


0. If the number of the elements in the input triples,
the time required for the selection sort
will grow by _______the square of the increase - a factor of 9___________.
Justification:
A tripled number of invocations of reigning champ will each take a triple amount of time to run the algorithm.