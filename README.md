# Scrypt Implementation in Java
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/LICENSE.txt)

## Overview

This repository contains a Java implementation of the Scrypt algorithm. Scrypt is a key derivation function designed to be memory-intensive and resistant to parallel processing, making it suitable for password hashing and other cryptographic applications.

## Features

- **Scrypt Algorithm Implementation:** The core of this application is the implementation of the Scrypt algorithm, providing a secure and efficient key derivation function.
  
- **Configurable Parameters:** The implementation allows you to configure various parameters of the Scrypt algorithm, such as N (CPU/memory cost), r (block size), and p (parallelization factor).

- **JavaFX User Interface:** The project includes a JavaFX-based user interface, allowing for easy interaction with the Scrypt implementation.
  
- **Usage Examples:** The repository includes examples and usage guidelines to help you integrate the Scrypt implementation into your Java projects securely.

## Getting Started

Follow these steps to get started with the Scrypt implementation:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/scrypt-java-implementation.git

## Configuration

Adjust the Scrypt parameters in the code according to your security requirements. The most common parameters are N, r, and p.

```java
int N = 16384; // CPU/Memory cost
int r = 8;     // Block size
int p = 1;     // Parallelization factor
```

## Preview of Application

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/1.png)

## Example Hash Generating in Application

### Input

```java
Plaintext: 123abcdefab
```

### Output

```java
Hash generated: $s0$e0801$eJFXz84VUfLMr/w+pvf9Aw==$iDxegp1WvrKCmJU8wcNHyCfDe6hqvK9XoTJmuy031Ac=
```

## Preview

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/2.png)

## Example Checking Hash Generated with same Plaintext in Application

```java
Using same plaintext for checking: 123abcdefab
```
```java
Using same hash generated: $s0$e0801$eJFXz84VUfLMr/w+pvf9Aw==$iDxegp1WvrKCmJU8wcNHyCfDe6hqvK9XoTJmuy031Ac=
```
## Preview

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/3.png)

## Example Checking Hash Generated with different Plaintext in Application

```java
Using different plaintext for checking: 123abcdefabtesting
```
```java
Using same hash generated: $s0$e0801$eJFXz84VUfLMr/w+pvf9Aw==$iDxegp1WvrKCmJU8wcNHyCfDe6hqvK9XoTJmuy031Ac=
```
## Preview

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/4.png)

## Example Checking with same Plaintext but different Hash Generated(removed a part from hash) in Application

```java
Using different plaintext for checking: 123abcdefab
```
```java
Real hash generated: $s0$e0801$eJFXz84VUfLMr/w+pvf9Aw==$iDxegp1WvrKCmJU8wcNHyCfDe6hqvK9XoTJmuy031Ac=
Part that is remove: $iDxegp1W
Hash with remove a part from hash: $s0$e0801$eJFXz84VUfLMr/w+pvf9Aw==vrKCmJU8wcNHyCfDe6hqvK9XoTJmuy031Ac=
```
## Preview

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/5.png)

## Example Generate hash with different Plaintext and test that hash to check using first Plaintext that we use in first example

```java
Using different plaintext for checking: abcdef12345
```

```java
Using this hash generated: $s0$e0801$58yftRUTdsTobztz/utyVQ==$elXHxsNEQnAZzw+E/jJfrEjyCMejaDd9g/4h4OFvJ2M=
```

```java
Using first plaintext from first example for checking: 123abcdefab
```

## Preview

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/6.png)
