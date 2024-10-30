# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Parser component
Parser's role is to given user input create a command which then can be executed. This particular implementation follows 
**Factory design pattern**. It exposes a general purpose method for parsing command `parseCommand(String input)` and then it determines
command types and creates one of the type. Regular expressions are heavily used for extracting information from input.
More details are presented on a sequence diagram someName.

![Diagram Description](./diagrams/ParsingSequenceDiagram.png)

#### Alternative approaches/Possible improvements:
- Command factory could be moved to a separate class 
- Creating a lexer object might be a desirable approach if the commands where much more complex

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
