# AP Computer Science Logic Assignment
May 5, 2017

**Introduction**

This assignment was an extension of the previous work that we had done in the APCS class regarding logic, and logical expressions. The project aims to test our understanding of logic and our ability to network and get feedback from external reviewers, and present was we learned.

**Specifications**

The requirements of this assignment was to create logic methods that included some logic operations on single sentences, comparing the properties of two sets of truth tables, and evaluating the logical properties of the truth table. Also, the methods and class was to follow documentation standards and be cleanly written. My methods fulfilled the specifications because they perform each of the evaluations properly, as tested in the main, and each of the methods are well documented and explain in depth what they do. 


**Overview of the code explaining, in broad strokes, the structure of it**

The class TruthColumn contains a private member variable “truthtable” which is a boolean array of truth values. The class also includes some helper methods, including the mutator setTruthTable which takes in a boolean array of values and assigns it to truthtable. The most important methods included in the code are the methods that propagate truth values into the truthtable by taking in two boolean arrays of truth assignments and evaluating them against each other. These include the and, or, negate, biconditional, and implies methods. Other methods like equivalent, entails, and consistent test the truth values from two separate sentences’ truth tables. These class methods take in a parameter of “otherTruthTable”, a boolean array of truth values to be compared to the truthtable values. The final set of methods - valid, unsatisfiable, and contingent evaluate the logical properties of the sentence based on the truth table values. They take no parameters and return a boolean value based on the result of the evaluation. 


**Acknowledgements**

Thank you to Stanford Logic for helping me understand the logical concepts in which to represent in code (http://intrologic.stanford.edu/notes/chapter_03.html).
