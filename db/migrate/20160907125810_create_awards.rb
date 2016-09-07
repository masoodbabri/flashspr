class CreateAwards < ActiveRecord::Migration[5.0]
  def change
    create_table :awards do |t|
    	t.text :name
    	t.timestamps
    end
  end
end
