import scala.collection.mutable.HashMap

/**
 * TwoSum
 * 
 * "Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target. You may assume
 * that each input would have exactly one solution, and you may not
 * use the same element twice."
 * 
 * Author: Aleksandr Molchagin
 * Date: Apr 4, 2022
 */
object Main extends App {

  val nums = Array(2,7,11,15)
  val target = 9
  println("(" + twoSumFast(nums, target).mkString(", ") + ")")

  /**
    * Standard brute-force solution. Goes through all pairs
    * of numbers and checks if they add up to the target.
    *
    * Time Complexity: O(n^2)
    * 
    * @param nums - array of int
    * @param target - search value
    * @return - array of indices of numbers that add up to target
    */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for( i <- 0 until nums.length){
      for( j <- 1 until nums.length){
        if (nums(i) + nums(j) == target){
          return Array(i, j)
        }
      }
    }
    return Array(0,0)
  }

  /**
    * 
    * Fast solution. Uses a HashMap to store the values of the array
    * and then checks if (target value - current value) is in the map.
    *
    * Time Complexity: O(n)
    * 
    * @param nums - array of int
    * @param target - search value
    * @return - array of indices of numbers that add up to target
    */
  def twoSumFast(nums: Array[Int], target: Int): Array[Int] = {
    var map: HashMap[Int, Int] = new HashMap[Int, Int]()

    for(i <- 0 until nums.length){
      if (map.contains(target - nums(i))){
        return Array(map(target - nums(i)), i)
      } else {
        map.put(nums(i), i)
      }
    }

    return Array(0,0)
  }
}