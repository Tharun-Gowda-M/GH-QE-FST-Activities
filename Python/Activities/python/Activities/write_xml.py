import pandas as pd

df = pd.DataFrame([[1.3, 1.4, 5.2],
                   [2.6, 1.4, 4.6],
                   [2.1, 5.6, 4.6]],
                  columns=['A', 'B', 'C'],
                  index=['X', 'Y', 'Z'])

# Writing the DataFrame to an XML file
df.to_xml('coordinates.xml', index=False)