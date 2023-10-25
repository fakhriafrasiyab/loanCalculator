# Loan Decision Engine

**Description:**
The Loan Decision Engine is a Java-based application designed to determine the maximum loan amount that can be approved for an individual based on their credit score. The system considers different scenarios such as existing debt, credit modifiers, loan amount, and loan period to make a decision on loan approval. It also ensures that the loan amount and period meet specified constraints.

**Table of Contents:**
1. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
2. [Usage](#usage)
   - [API Endpoint](#api-endpoint)
3. [Scenarios](#scenarios)
4. [Contributing](#contributing)
5. [License](#license)

## Getting Started

### Prerequisites
Before running the application, ensure you have the following dependencies installed:

- Java 17 or higher
- Maven (for building the project)
- An IDE for Java development (e.g., Eclipse, IntelliJ IDEA)

### Installation
1. Clone the repository to your local machine.
   ```bash
   git clone https://github.com/fakhriafrasiyab/loanCalculator.git
   ```

2. Build the Java application using Maven.
   ```bash
   mvn clean install
   ```

## Usage

### API Endpoint
The Loan Decision Engine provides a single API endpoint for loan approval. You can start the Java application and access the endpoint to get loan decisions. The API accepts personal codes, loan amount, and loan period in months and returns a decision (negative or positive) and the approved loan amount.

**API Endpoint:**
```
http://localhost:5000/api/loan
```

**Sample Request:**
```http
POST /api/loan
Content-Type: application/json

{
  "customer": {
    "name":"User"
  },
  "loanAmount": 4000,
  "loanPeriod": 36
}
```

**Sample Response:**
```json
{
  "decision": "positive",
  "loanAmount": 1200
}
```

## Scenarios

The Loan Decision Engine handles the following scenarios:
- Debt: If a person has debt, the engine does not approve any loan amount.
- Segment 1: Credit modifier is 100.
- Segment 2: Credit modifier is 300.
- Segment 3: Credit modifier is 1000.

The credit score is calculated using a primitive algorithm. If the credit score is less than 1, the engine does not approve the loan; otherwise, it provides the approved loan amount.

## Contributing

If you would like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your changes.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request to the original repository.
