import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:

    duplicates = person['email'].value_counts()
    duplicates = duplicates[duplicates > 1]

   # print(duplicates)

    return duplicates.index.to_frame(name="email")