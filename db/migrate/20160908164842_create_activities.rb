class CreateActivities < ActiveRecord::Migration[5.0]
  def change
    create_table :activities do |t|
      t.integer :author_id
      t.integer :recipient_id
      t.integer :category_id

      t.timestamps
    end
  end
end
