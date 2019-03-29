# Matrix
Git clone repo and import in eclipse
Run com.amura.matrix.controller.MatrixApplication as SpringBoot Application

Access service on below url :
   http://localhost:8080/matrix/v1/submatrix
   Request Type : POST
   
  Sample Request :
  {"matrix" : [
    [1,0,1],
    [1,0,2]
  ]}
  
  Sample Response :
  {
    "x": 0,
    "y": 0,
    "width": 1,
    "height": 2
}
