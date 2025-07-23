# Java Collections Framework Examples

This project contains comprehensive implementations of various Java Collections Framework problems organized by interface type.

## Project Structure

```
Collections/
├── src/
│   ├── list/               # List Interface implementations
│   │   ├── ReverseList.java
│   │   ├── ElementFrequency.java
│   │   ├── RotateList.java
│   │   ├── RemoveDuplicates.java
│   │   └── NthFromEnd.java
│   ├── set/                # Set Interface implementations
│   │   ├── SetOperations.java
│   │   └── InsurancePolicyManagement.java
│   ├── queue/              # Queue Interface implementations
│   │   ├── QueueOperations.java
│   │   ├── HospitalTriageSystem.java
│   │   ├── StackUsingQueues.java
│   │   └── CircularBuffer.java
│   ├── map/                # Map Interface implementations
│   │   ├── WordFrequencyCounter.java
│   │   ├── MapOperations.java
│   │   └── GroupByProperty.java
│   ├── systems/            # Complete system implementations
│   │   ├── InsurancePolicyMapSystem.java
│   │   ├── VotingSystem.java
│   │   ├── ShoppingCart.java
│   │   └── BankingSystem.java
│   └── main/
│       └── CollectionsDemo.java
```

## List Interface Problems

1. **ReverseList.java** - Reverse elements without built-in methods (ArrayList & LinkedList)
2. **ElementFrequency.java** - Count frequency of elements in a Map
3. **RotateList.java** - Rotate elements by given positions
4. **RemoveDuplicates.java** - Remove duplicates while preserving order
5. **NthFromEnd.java** - Find Nth element from end in LinkedList

## Set Interface Problems

1. **SetOperations.java** - Set equality, union, intersection, symmetric difference, subset operations
2. **InsurancePolicyManagement.java** - Complete insurance policy management using HashSet, LinkedHashSet, TreeSet

## Queue Interface Problems

1. **QueueOperations.java** - Queue reversal and binary number generation
2. **HospitalTriageSystem.java** - Priority queue implementation for hospital triage
3. **StackUsingQueues.java** - Stack implementation using two queues
4. **CircularBuffer.java** - Fixed-size circular buffer implementation

## Map Interface Problems

1. **WordFrequencyCounter.java** - Count word frequency from text/file
2. **MapOperations.java** - Map inversion, find max value key, merge maps
3. **GroupByProperty.java** - Group employees by department

## System Implementations

1. **InsurancePolicyMapSystem.java** - Policy management using HashMap, LinkedHashMap, TreeMap
2. **VotingSystem.java** - Voting system with different map implementations
3. **ShoppingCart.java** - Shopping cart with product pricing and sorting
4. **BankingSystem.java** - Banking system with account management and withdrawal queue

## How to Run

Each class contains its own `main` method for demonstration. To run any example:

1. Navigate to the Collections directory
2. Compile the Java file:
   ```
   javac -d . src/package_name/ClassName.java
   ```
3. Run the compiled class:
   ```
   java package_name.ClassName
   ```

For example, to run the ReverseList example:
```
javac -d . src/list/ReverseList.java
java list.ReverseList
```

## Features Demonstrated

- **List Operations**: Reversing, frequency counting, rotation, duplicate removal
- **Set Operations**: Union, intersection, difference, subset checking
- **Queue Operations**: Reversal, priority handling, stack simulation
- **Map Operations**: Frequency counting, inversion, grouping, merging
- **Performance Comparisons**: HashSet vs LinkedHashSet vs TreeSet
- **Real-world Applications**: Insurance management, hospital systems, banking, voting

All implementations are done without comments as requested and demonstrate various collection types and their specific use cases.
