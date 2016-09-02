class CreateStaffs < ActiveRecord::Migration[5.0]
  def change
    create_table :staffs do |t|
      t.string :first_name, null: false
      t.string :last_name,  null: false
      t.string :title,      null: false
      t.string :email,      null: false

      t.timestamps          null: false
    end

    add_index :staffs, :email, unique: true
  end
end
