/*
Dawid Ćwik
238137
23.11.2017r.
Informatyka III
 */

#include <iostream>
#include <iostream>
#include <fstream>
#include <Eigen/Dense>
#include <ctime>
#include <algorithm>

using namespace Eigen;
using namespace std;

MatrixXd readFromFileSaveToMatrix(const char *path, int size){
  MatrixXd temp;
  temp.resize(size,size);

  ifstream data (path);
  if (data.is_open()) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        float item = 0.0;
        data >> item;
        temp(i,j) = item;
      }
    }
    data.close();
  }
  return temp;
}

VectorXd readFromFileSaveToVector(const char *path, int size){
  VectorXd temp;
  temp.resize(size);

  ifstream data (path);
  if (data.is_open()) {
    for (int i = 0; i < size; i++) {
      float item = 0.0;
      data >> item;
      temp(i) = item;
    }
    data.close();
  }
  return temp;
}

double avg(double *times, int size) {
  double total;
  for (int i = 0; i < 10; i++) {
    total += times[i];
  }

  return (total/(double)size);
}


int main(int argc, char *argv[]) {
  if (argc > 0 ) {
    IOFormat HeavyFmt(20, 0, ", ", "\n", "", "", "", "");
    std::cout << argv[1] << '\n';
    int size = atoi(argv[1]);
    std::cout << '\n'<< '\n'<< "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"<< '\n';
    MatrixXd A;
    A.resize(size,size);
    A = readFromFileSaveToMatrix("MatrixA.txt", size);
    MatrixXd B;
    B.resize(size,size);
    B = readFromFileSaveToMatrix("MatrixB.txt", size);
    MatrixXd C;
    C.resize(size,size);
    C = readFromFileSaveToMatrix("MatrixC.txt", size);

    VectorXd X;
    X.resize(size);
    X = readFromFileSaveToVector("Vector.txt", size);

    VectorXd result;
    result.resize(size);
    MatrixXd resultMatrix;
    resultMatrix.resize(size, size);

    double endTime;
    clock_t beginTime;
    double elapsedTimes[1000];

    for (int i = 0; i < 1000; i++) {
      beginTime = clock();
      result = A*X;
      endTime = double( clock () - beginTime ) /  CLOCKS_PER_SEC*1000000000;
      elapsedTimes[i] = endTime;
    }
    std::cout <<"CZAS: " << avg(elapsedTimes, 1000) << '\n';
    cout << "A*X = " << endl << result.format(HeavyFmt) << endl << endl;

    std::fill_n(elapsedTimes, 10 , 0);
    for (int i = 0; i < 1000; i++) {
      beginTime = clock();
      result = (A+B+C)*X;
      endTime = double( clock () - beginTime ) /  CLOCKS_PER_SEC*1000000000;
      elapsedTimes[i] = endTime;
    }
    std::cout <<"CZAS: " << avg(elapsedTimes, 1000) << '\n';
    cout << "(A+B+C)*X = "<< endl << result.format(HeavyFmt) << endl << endl;

    // std::fill_n(elapsedTimes, 10 , 0);
    // for (int i = 0; i < 1000; i++) {
    //   beginTime = clock();
    //   resultMatrix = B*C*A;
    //   endTime = double( clock () - beginTime ) /  CLOCKS_PER_SEC*1000000000;
    //   elapsedTimes[i] = endTime;
    // }
    // std::cout <<"CZAS: " << avg(elapsedTimes, 1000) << '\n';
    //  cout << "A*(B*C) = " << endl <<resultMatrix<< endl << endl;

    std::fill_n(elapsedTimes, 10 , 0);
    for (int i = 0; i < 1000; i++) {
      beginTime = clock();
      result = A.partialPivLu().solve(X);
      endTime = double( clock () - beginTime ) /  CLOCKS_PER_SEC*1000000000;
      elapsedTimes[i] = endTime;
    }
    std::cout <<"CZAS: " << avg(elapsedTimes, 1000) << '\n';
    cout << "A*X=B" << endl << result.format(HeavyFmt) << endl <<endl;
  //
  //   std::fill_n(elapsedTimes, 10 , 0);
  //   for (int i = 0; i < 1000; i++) {
  //     beginTime = clock();
  //     result = A.fullPivLu().solve(X);
  //     endTime = double( clock () - beginTime ) /  CLOCKS_PER_SEC*1000000000;
  //     elapsedTimes[i] = endTime;
  //   }
  //   std::cout <<"CZAS: " << avg(elapsedTimes, 1000) << '\n';
  // cout << "A*X=B" << endl << result << endl << endl;
  }
}
