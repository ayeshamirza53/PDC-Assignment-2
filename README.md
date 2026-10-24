# Parallel and Distributed Computing (PDC) - Assignment 2

## Project Overview
This repository contains the complete implementation for PDC Assignment 2, covering multithreading, concurrent data structures, parallel task execution using Fork/Join frameworks, and CPU cache locality analysis in Java.

---

## Assignment Structure & Implementation Summary

### Question 1: Financial Event Dispatcher
- **Files**: `TradeEvent.java`, `FIXOrderEvent.java`, `ReutersQuoteEvent.java`, `TradingEngineApp.java`
- **Key Concepts**: Polymorphism, method dispatching, custom event routing.

### Question 2: Packet Symmetry Auditor
- **Files**: `TransactionStack.java`, `RequestQueue.java`, `PacketSymmetryAuditor.java`
- **Key Concepts**: Custom data structures (fixed array stack, circular queue), palindrome verification.

### Question 3: Async Web Engine & Multithreading
- **Files**: `LogProcessorTask.java`, `TelemetryThread.java`, `AsyncWebEngineApp.java`
- **Key Concepts**: Concurrent execution, `Thread` vs `Runnable`, JVM thread status logging.

### Question 4: Portfolio Risk Calculator (Fork/Join Framework)
- **Files**: `ParallelRiskCalculator.java`, `PortfolioThresholdTask.java`, `ForkJoinPortfolioApp.java`
- **Key Concepts**: `ForkJoinPool`, `RecursiveTask`, `RecursiveAction`, parallel array processing.

### Question 5: Sensor Grid Monitoring
- **Files**: `SensorSearchEngine.java`, `ParallelMinSearch.java`, `ParallelMaxSearch.java`, `SensorGridMonitorApp.java`
- **Key Concepts**: Abstract classes, multithreaded array reductions for min/max values.

### Question 6: Concurrent Map Benchmarking
- **Files**: `InventoryCatalogManager.java`
- **Key Concepts**: `Collections.synchronizedMap` vs `ConcurrentHashMap`, throughput analysis under heavy thread contention.

### Question 7: Cache Locality Analysis
- **Files**: `CacheLocalityBenchmark.java`
- **Key Concepts**: Spatial locality, Row-Major vs Column-Major 2D array traversal, CPU L1/L2 cache line hits and misses.

---

## How to Run

1. Open the project in VS Code or any Java IDE.
2. Compile and run individual driver applications:
   ```bash
   javac *.java
   java TradingEngineApp
   java PacketSymmetryAuditor
   java AsyncWebEngineApp
   java ForkJoinPortfolioApp
   java SensorGridMonitorApp
   java InventoryCatalogManager
   java CacheLocalityBenchmark
