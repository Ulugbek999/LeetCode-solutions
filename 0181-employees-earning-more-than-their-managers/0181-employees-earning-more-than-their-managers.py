import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:

    #sql join is pandas merge:

    merged = employee.merge(employee, left_on="managerId", right_on="id")


    #this only keeps the rows whre the condition is true:
    filtered = merged[merged["salary_x"] > merged["salary_y"]]
    result = filtered[["name_x"]]
    result.columns = ["Employee"]
    return result
