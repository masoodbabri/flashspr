class AddIndexToAwards < ActiveRecord::Migration[5.0]
  def change
  	add_index :awards, :name, unique: true
  end
end
