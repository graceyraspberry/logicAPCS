# AP Computer Science Logic Assignment
May 5, 2017

**Introduction**

This assignment was an extension of the previous work that we had done in the APCS class regarding logic, and logical expressions. The project aims to test our understanding of logic and our ability to network and get feedback from external reviewers, and present was we learned.

**How this fulfills / does not fulfill the specification**

The requirements of this assignment was to create logic methods that included some logic operations on single sentences, comparing the properties of two sets of truth tables, and evaluating the logical properties of the truth table. Also, the methods and class was to follow documentation standards and be cleanly written. My methods fulfilled the specifications because they perform each of the evaluations properly, as tested in the main, and each of the methods are well documented and explain in depth what they do. 

**Explanation of current errors (or anything that falls short of project specifications) and how you might fix them**

There are no bugs or errors in the code, however, one thing that could make the design of the class better would be to create a print method that nicely arranges the propositional constant values and aligns it with the evaluated truth table values to make it easier to comprehend visually.

**Overview of the code explaining, in broad strokes, the structure of it**

The class TruthColumn contains a private member variable “truthtable” which is a boolean array of truth values. The class also includes some helper methods, including the mutator setTruthTable which takes in a boolean array of values and assigns it to truthtable. The most important methods included in the code are the methods that propagate truth values into the truthtable by taking in two boolean arrays of truth assignments and evaluating them against each other. These include the and, or, negate, biconditional, and implies methods. Other methods like equivalent, entails, and consistent test the truth values from two separate sentences’ truth tables. These class methods take in a parameter of “otherTruthTable”, a boolean array of truth values to be compared to the truthtable values. The final set of methods - valid, unsatisfiable, and contingent evaluate the logical properties of the sentence based on the truth table values. They take no parameters and return a boolean value based on the result of the evaluation. 

**Discussion of major challenges encountered in the process of making the code**

One of the challenges I encountered in the process of making the code was how to name my variables in a way that would be easily understandable and not too confusing to the viewer.  I decided to name my private member variable with an underscore as well to differentiate it from the local variables. Also, it was a challenge to make a solid test case that would be cohesive and flow well, as well as clearly prove the efficacy and accuracy of the method. 

**Acknowledgements (who helped you, what resources you used etc.)**

Thank you to Stanford Logic for helping me understand the logical concepts in which to represent in code (http://intrologic.stanford.edu/notes/chapter_03.html) and to my external reviewers for listening to me explain my code.
